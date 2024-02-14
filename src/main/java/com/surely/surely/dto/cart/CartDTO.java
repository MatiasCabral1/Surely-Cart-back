package com.surely.surely.dto.cart;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.surely.surely.dto.AbstractDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.models.cart.Cart;
import com.surely.surely.models.cart.E_CartStatus;

public class CartDTO extends AbstractDTO {

	/**
	 * cart status
	 */
	private E_CartStatus status;

	/**
	 * creation timestamp
	 */
	private Date timestamp;

	/**
	 * user owner
	 */
	private UserDTO user;

	/**
	 * total price
	 */
	private BigDecimal price;

	/**
	 * cart items
	 */
	private List<CartItemDTO> cartItems;

	public CartDTO() {
		super();
	}

	public CartDTO(E_CartStatus status, Date timestamp, UserDTO user, BigDecimal price, List<CartItemDTO> cartItems) {
		super();
		this.status = status;
		this.timestamp = timestamp;
		this.user = user;
		this.price = price;
		this.cartItems = cartItems;
	}

	@Override
	public Class<Cart> mapTo() {
		return Cart.class;
	}

	public E_CartStatus getStatus() {
		return status;
	}

	public void setStatus(E_CartStatus status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}

	public ProductDTO getMostCheapProduct() {
		return this.getCartItems().stream().map(CartItemDTO::getProduct).min(Comparator.comparing(ProductDTO::getPrice))
				.orElse(null);
	}

	public void addCartItem(CartItemDTO cartItem) {
		this.getCartItems().add(cartItem);
		this.setTimestamp(new Date());
		this.updatePrice();
	}

	public void removeCartItem(CartItemDTO cartItem) {
		this.getCartItems().remove(cartItem);
		this.updatePrice();
	}

	public void updatePrice() {
		BigDecimal totalPrice = BigDecimal.ZERO;
		for (CartItemDTO item : this.getCartItems()) {
			totalPrice = totalPrice.add(item.subtotal());
		}
		this.setPrice(totalPrice);
	}
	
	public int getNumberOfProducts() {
	    return this.getCartItems().stream()
	            .mapToInt(CartItemDTO::getNumberOfProducts)
	            .sum(); 
	}

}
