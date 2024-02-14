package com.surely.surely.dto.cart;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surely.surely.dto.AbstractDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.models.cart.CartItem;

/**
 * CartItem DTO
 * 
 * @author Matias
 *
 */
public class CartItemDTO extends AbstractDTO {
	/*
	 * 
	 */
	private Date timestamp;
	/*
	 * 
	 */
	private BigDecimal purchasePrice;
	/**
	 * 
	 */
	private int numberOfProducts;
	/**
	 * product
	 */
	private ProductDTO product;

	/**
	 * cart
	 */
	@JsonIgnore
	private CartDTO cart;

	public CartItemDTO() {
		super();
	}

	public CartItemDTO(Date timestamp, BigDecimal purchasePrice, int numberOfProducts) {
		super();
		this.timestamp = timestamp;
		this.purchasePrice = purchasePrice;
		this.numberOfProducts = numberOfProducts;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	@Override
	public Class<CartItem> mapTo() {
		return CartItem.class;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public CartDTO getCart() {
		return cart;
	}

	public void setCart(CartDTO cart) {
		this.cart = cart;
	}

	public CartItemDTO(Date timestamp, BigDecimal purchasePrice, int numberOfProducts, ProductDTO product, CartDTO cart) {
		super();
		this.timestamp = timestamp;
		this.purchasePrice = purchasePrice;
		this.numberOfProducts = numberOfProducts;
		this.product = product;
		this.cart = cart;
	}
	
	public BigDecimal subtotal() {
		return purchasePrice.multiply(new BigDecimal(this.numberOfProducts));
	}

}
