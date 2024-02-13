package com.surely.surely.controllers.cart;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.surely.surely.dto.cart.AddToCartRequestDTO;
import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.product.CartProductResponseDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.services.cart.I_CartService;

@Controller
@RequestMapping("/api/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private I_CartService cartService;

	@GetMapping("/findCarts")
	public ResponseEntity<List<CartDTO>> findAll() {
		logger.debug("executing CartController_findAll()");
		Optional<List<CartDTO>> cart = cartService.findAll();
		if (cart.isPresent()) {
			return ResponseEntity.ok(cart.get());
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/findById/{cartId}")
	public ResponseEntity<CartDTO> findById(@PathVariable Long cartId) {
		logger.debug("executing CartController_findById()");
		Optional<CartDTO> cart = cartService.findById(cartId);
		if (cart.isPresent()) {
			return ResponseEntity.ok(cart.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/findByDocumentNumber/{documentNumber}")
	public ResponseEntity<CartDTO> findByDocumentNumber(@PathVariable String documentNumber) {
		logger.debug("executing CartController_findByDocumentNumber()");
		CartDTO cart = cartService.findByDocumentNumber(documentNumber);
		return ResponseEntity.ok(cart);
	}

	@PostMapping("/createCart")
	public ResponseEntity<Long> createCart(@RequestBody String documentNumber) {
		logger.debug("executing CartController_createCart()");
		Long createdCart = cartService.createByDocumentNumber(documentNumber);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
	}

	@PostMapping("/payCart")
	public ResponseEntity<?> payCart(@RequestBody Long cartId) {
		logger.debug("executing CartController_payCart()");
		cartService.payByCartId(cartId);
		return ResponseEntity.ok("Payment successful");
	}

	@PostMapping("/addToCart")
	public ResponseEntity<CartProductResponseDTO> addToCart(@RequestBody AddToCartRequestDTO request) {
		logger.debug("executing CartController_addToCart()");
		CartProductResponseDTO response = cartService.addProductToCart(request.getCartId(), request.getProductId(),
				request.getQuantity());
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/removeFromCart/{cartId}/{productId}")
	public ResponseEntity<CartProductResponseDTO> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
		logger.debug("executing CartController_removeProductFromCart()");
		CartProductResponseDTO response = cartService.removeProductFromCart(cartId, productId);
		return ResponseEntity.ok(response);

	}

	@DeleteMapping("/deleteCart/{cartId}")
	public ResponseEntity<String> deleteCart(@PathVariable Long cartId) {
		cartService.deleteCartById(cartId);
		return ResponseEntity.ok("Cart deleted successfully");

	}

	@PostMapping("/mostExpensiveProducts")
	public ResponseEntity<?> getMostExpensiveProducts(@RequestBody String documentNumber) {
		List<ProductDTO> products = cartService.getMostExpensiveProducts(documentNumber);
		return ResponseEntity.ok(products);
	}
}
