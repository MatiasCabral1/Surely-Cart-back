package com.surely.surely.services.cart;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.product.CartProductResponseDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.models.cart.Cart;
import com.surely.surely.services.I_AbstractService;

@Service
public interface I_CartService extends I_AbstractService<Cart, Long, CartDTO> {

	public Long createByDocumentNumber(String documentNumber);

	public CartProductResponseDTO addProductToCart(Long idProduct, Long idCart, int quantity);

	public CartProductResponseDTO removeProductFromCart(Long idProduct, Long idCart);

	public List<ProductDTO> getMostExpensiveProducts(String documentNumber);

	public void payByCartId(Long cartId);

	public void deleteCartById(Long cartId);
	
	public CartDTO findByDocumentNumber(String documentNumber);
}
