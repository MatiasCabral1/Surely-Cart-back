package com.surely.surely.models.cart;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.SQLRestriction;

import com.surely.surely.dto.cart.CartItemDTO;
import com.surely.surely.models.EntityMapTo;
import com.surely.surely.models.product.Product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Cart item for cart
 * 
 * @author Matias
 *
 */
@Entity
@SQLRestriction("deleted = false")
public class CartItem extends EntityMapTo {

	/**
	 * identity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * product
	 */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * cart
	 */
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	/**
	 * deleted
	 */
	@Column
	private Boolean deleted = Boolean.FALSE;

	/**
	 * creation timestamp
	 */
	@Column
	private Date timestamp;

	/**
	 * price at the time of purchase
	 */
	@Column
	private BigDecimal purchasePrice;

	/**
	 * Number of products
	 */
	@Column
	private int numberOfProducts;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	@Override
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public Class<CartItemDTO> mapTo() {
		return CartItemDTO.class;
	}

}
