package com.surely.surely.services.cart;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.surely.surely.repositories.cart.CartRepository;
import com.surely.surely.services.AbstractService;
import com.surely.surely.services.product.I_ProductService;
import com.surely.surely.services.promotion.I_PromotionService;
import com.surely.surely.services.user.I_UserService;
import com.surely.surely.utils.CodedException;
import com.surely.surely.utils.ValidationUtils;
import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.cart.CartItemDTO;
import com.surely.surely.dto.product.CartProductResponseDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.models.cart.Cart;
import com.surely.surely.models.cart.E_CartStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Cart Service
 * 
 * @author Matias
 *
 */
@Service
public class CartService extends AbstractService<Cart, Long, CartDTO> implements I_CartService {

	private static final Logger logger = LoggerFactory.getLogger(CartService.class);

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private I_UserService userService;

	@Autowired
	private I_ProductService productService;

	@Autowired
	private I_CartItemService cartItemService;

	@Autowired
	private I_PromotionService promotionService;

	@Override
	@Transactional
	public Long createByDocumentNumber(String documentNumber) {
		logger.debug("executing cartService_CreateByDocumentNumber() with params -  documentNumber: {} ",
				documentNumber);

		Optional<UserDTO> user = this.getUserService().findByDocumentNumber(documentNumber);

		if (user.isEmpty()) {
			throw new CodedException("No se encontró ningún usuario con el número de documento: " + documentNumber);
		}
		Optional<CartDTO> cart = this.findByUserIdAndStatus(user.get().getId());
		if (cart.isPresent()) {
			logger.error("error executing createByDocumentNumber -> the user already has a cart");

			throw new CodedException(
					"El usuario con número de documento: " + documentNumber + " ya dispone de un carrito");
		}

		CartDTO newCart = new CartDTO();
		newCart.setPrice(new BigDecimal(0));
		newCart.setUser(user.get());
		newCart.setTimestamp(new Date());
		newCart.setStatus(E_CartStatus.IN_PROCESS);

		Optional<CartDTO> savedCart = this.save(newCart);

		if (savedCart.isEmpty()) {
			logger.error("error executing createByDocumentNumber -> An error occurred while persisting the cart");
			throw new CodedException("Error al generar el carrito");
		}

		return savedCart.get().getId();
	}

	@Override
	@Transactional
	public void payByCartId(Long idCart) {
		logger.debug("executing cartService_payByCartId() with params -  cartId: {} ", idCart);

		CartDTO cart = ValidationUtils.optionalIsEmpty(this.findById(idCart),
				"No se encontró un carrito con el id: " + idCart);
		validateCartStatus(cart);
		this.getPromotionService().applyDiscount(cart);
		cart.setStatus(E_CartStatus.FINISHED);

		this.save(cart);
	}

	@Transactional
	public CartProductResponseDTO addProductToCart(Long idCart, Long idProduct, int quantity) {
		logger.debug("Executing cartService_addToCart() with parameters - idProduct: {}, idCart: {}", idProduct,
				idCart);
		ProductDTO product = ValidationUtils.optionalIsEmpty(productService.findById(idProduct),
				"No se encontró un producto con el id: " + idProduct);
		CartDTO cart = ValidationUtils.optionalIsEmpty(this.findById(idCart),
				"No se encontró un carrito con el id: " + idCart);
		if (cart.getStatus().equals(E_CartStatus.FINISHED))
			throw new CodedException("No se pueden agregar productos a este carrito.");
		findOrCreateCartItem(cart, product, quantity);
		cart.updatePrice();
		Optional<CartDTO> savedCartOptional = this.save(cart);

		if (savedCartOptional.isEmpty()) {
			logger.error(
					"error executing removeProductFromCart -> A cartItem was not found associated with the product");
			throw new CodedException("Error al agregar el producto al carrito");
		}
		CartDTO savedCart = savedCartOptional.get();
		CartProductResponseDTO response = new CartProductResponseDTO();
		response.setId(savedCart.getId());
		response.setStatus(savedCart.getStatus());
		response.setCartItems(savedCart.getCartItems());
		response.setPrice(savedCart.getPrice());

		return response;
	}

	@Override
	@Transactional
	public CartProductResponseDTO removeProductFromCart(Long idCart, Long idProduct) {
		logger.debug("executing cartService_removeProductFromCart() with params - idProduct {} - idCart: {} ",
				idProduct, idCart);
		
		CartDTO cart = ValidationUtils.optionalIsEmpty(this.findById(idCart),
				"No se encontró un carrito con el id: " + idCart);
		
		validateCartStatus(cart);
		Optional<CartItemDTO> cartItemOptional = cart.getCartItems().stream()
				.filter(cartItem -> cartItem.getProduct().getId().equals(idProduct)).findFirst();
		ValidationUtils.optionalIsEmpty(cartItemOptional,
				"El producto con id " + idProduct + " no existe en el carrito con id " + idCart);
		
		CartItemDTO cartItem = cartItemOptional.get();
		cart.removeCartItem(cartItem);
		this.save(cart);

		cartItemService.deleteById(cartItem.getId());
		
		CartProductResponseDTO response = new CartProductResponseDTO();
		response.setId(cart.getId());
		response.setStatus(cart.getStatus());
		response.setCartItems(cart.getCartItems());
		response.setPrice(cart.getPrice());
		
		return response;
	}

	public void deleteCartById(Long idCart) {
		logger.debug("executing cartService_deleteCartById() with params -- idCart: {} ", idCart);
		
		CartDTO cart = ValidationUtils.optionalIsEmpty(this.findById(idCart),
				"No se encontró un carrito con el id: " + idCart);
		validateCartStatus(cart);
		cart.getCartItems().forEach(item -> item.setDeleted(true));
		cart.setStatus(E_CartStatus.CANCELLED);
		this.save(cart);
		cart.getCartItems().forEach(item -> this.cartItemService.deleteById(item.getId()));
		this.deleteById(idCart);
	}
	
	@Transactional
	public CartDTO findByDocumentNumber(String documentNumber) {
		logger.debug("executing cartService_documentNumber() with params -- documentNumber: {} ", documentNumber);
		UserDTO user = ValidationUtils.optionalIsEmpty(this.getUserService().findByDocumentNumber(documentNumber),
				"no se encuentra el usuario con numero de documento: " + documentNumber);

		CartDTO cart = ValidationUtils.optionalIsEmpty(this.findByUserIdAndStatus(user.getId()),
				"No se encontró un carrito para el usuario con numero de documento: " + documentNumber);
		
		return cart;
	}

	@Override
	public List<ProductDTO> getMostExpensiveProducts(String documentNumber) {
		logger.debug("executing CartService_getMostExpensiveProducts().");
		
		UserDTO user = ValidationUtils.optionalIsEmpty(this.getUserService().findByDocumentNumber(documentNumber),
				"no se encuentra el usuario con numero de documento: " + documentNumber);

		List<ProductDTO> result = ValidationUtils.listIsEmpty(
				productService.findTopExpensiveProductsByUserId(user.getId()), "El usuario no tiene compras previas.");
		
		return result;
	}

	private void findOrCreateCartItem(CartDTO cart, ProductDTO product, int quantity) {
		logger.debug("executing CartService_findOrCreateCartItem().");
		
		Optional<CartItemDTO> existingCartItemOptional = cart.getCartItems().stream()
				.filter(cartItem -> cartItem.getProduct().getId().equals(product.getId())).findFirst();

		if (existingCartItemOptional.isPresent()) {
			if (quantity <= 0)
				throw new CodedException("La cantidad de productos a agregar debe ser mayor a 0");
			CartItemDTO existingCartItem = existingCartItemOptional.get();
			logger.debug("Updating cartItem with product_id: {}", product.getId());
			existingCartItem.setNumberOfProducts(existingCartItem.getNumberOfProducts() + quantity);
		} else {
			logger.debug("Creating cartItem with product_id: {}", product.getId());
			
			CartItemDTO newCartItem = new CartItemDTO();
			newCartItem.setProduct(product);
			newCartItem.setNumberOfProducts(quantity);
			newCartItem.setTimestamp(new Date());
			newCartItem.setPurchasePrice(product.getPrice());
			newCartItem.setCart(cart);
			
			cart.addCartItem(newCartItem);
		}
	}

	public void validateCartStatus(CartDTO cart) {
		logger.debug("executing validateCartStatus");
		if (cart.getStatus().equals(E_CartStatus.FINISHED)) {
			logger.error("validateCartStatus -> error, this cart status is FINISHED");
			throw new CodedException("Este carrito no esta disponible");
		}
	}

	public Optional<CartDTO> findByUserIdAndStatus(Long userId) {
		return mapEntityToDTO(cartRepository.findByUserIdAndStatus(userId, E_CartStatus.IN_PROCESS));
	}

	public I_PromotionService getPromotionService() {
		return promotionService;
	}

	public void setPromotionService(I_PromotionService promotionService) {
		this.promotionService = promotionService;
	}

	@Override
	public JpaRepository<Cart, Long> getRepository() {
		return cartRepository;
	}

	public void setRepository(CartRepository cartRepository) {
		this.cartRepository = cartRepository;
	}

	public I_UserService getUserService() {
		return userService;
	}

	public void setUserService(I_UserService userService) {
		this.userService = userService;
	}

}
