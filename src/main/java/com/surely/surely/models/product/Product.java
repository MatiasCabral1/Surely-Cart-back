/**
 * 
 */
package com.surely.surely.models.product;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.format.annotation.DateTimeFormat;

import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.models.EntityMapTo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Product Entity
 * 
 * @author Matias
 */
@Entity
@SQLRestriction("deleted = false AND enabled = true")
@Table(name = "product")
public class Product extends EntityMapTo {

	/**
	 * identity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * creation timestamp
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column
	private Date timestamp;

	/**
	 * deleted
	 */
	@Column
	private Boolean deleted = Boolean.FALSE;

	/**
	 * enabled
	 */
	@Column
	private Boolean enabled = Boolean.TRUE;

	/**
	 * product name
	 */
	@Column
	private String name;

	/**
	 * product category
	 */
	@Column
	@Enumerated(EnumType.STRING)
	private E_ProductCategory productCategory;

	/**
	 * product stock
	 */
	@Column
	private int stock;

	/**
	 * product price
	 */
	@Column
	private BigDecimal price;

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

	@Override
	public Class<ProductDTO> mapTo() {
		return ProductDTO.class;
	}

}
