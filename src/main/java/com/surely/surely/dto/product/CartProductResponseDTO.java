package com.surely.surely.dto.product;

import java.math.BigDecimal;
import java.util.List;

import com.surely.surely.dto.cart.CartItemDTO;
import com.surely.surely.models.cart.CartItem;
import com.surely.surely.models.cart.E_CartStatus;
/**
 * Response for remove product from cart
 * 
 * @author Matias
 *
 */
public class CartProductResponseDTO {
	private Long cartId;
	private E_CartStatus status;
	private List<CartItemDTO> cartItems;
	private BigDecimal price;
	
	public CartProductResponseDTO() {
		super();
	}
	public CartProductResponseDTO(Long id, E_CartStatus status, List<CartItemDTO> cartItems, BigDecimal total) {
		super();
		this.cartId = id;
		this.status = status;
		this.cartItems = cartItems;
		this.price = total;
	}
	
	public Long getId() {
		return cartId;
	}
	public void setId(Long id) {
		this.cartId = id;
	}
	public E_CartStatus getStatus() {
		return status;
	}
	public void setStatus(E_CartStatus status) {
		this.status = status;
	}
	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal total) {
		this.price = total;
	}
	
}
