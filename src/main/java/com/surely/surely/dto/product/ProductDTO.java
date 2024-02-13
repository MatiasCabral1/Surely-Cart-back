package com.surely.surely.dto.product;

import java.math.BigDecimal;
import java.util.Date;

import com.surely.surely.dto.AbstractDTO;
import com.surely.surely.models.product.E_ProductCategory;
import com.surely.surely.models.product.Product;

/**
 * Product DTO
 * 
 * @author Matias
 *
 */
public class ProductDTO extends AbstractDTO {

	/**
	 * timestamp
	 */
	private Date timestamp;

	/**
	 * enabled
	 */
	private Boolean enabled = Boolean.TRUE;

	/**
	 * product name
	 */
	private String name;

	/**
	 * product category
	 */
	private E_ProductCategory productCategory;

	/**
	 * product stock
	 */
	private int stock;

	/**
	 * product price
	 */
	private BigDecimal price;

	@Override
	public Class<?> mapTo() {
		return Product.class;
	}

	public ProductDTO() {
		super();
	}

	public ProductDTO(Date timestamp, Boolean enabled, String name, E_ProductCategory productCategory, int stock,
			BigDecimal price) {
		super();
		this.timestamp = timestamp;
		this.enabled = enabled;
		this.name = name;
		this.productCategory = productCategory;
		this.stock = stock;
		this.price = price;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public E_ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(E_ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
