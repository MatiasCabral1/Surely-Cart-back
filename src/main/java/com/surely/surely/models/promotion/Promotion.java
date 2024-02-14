/**
 * 
 */
package com.surely.surely.models.promotion;

import java.util.Date;

import org.hibernate.annotations.SQLRestriction;
import org.springframework.format.annotation.DateTimeFormat;

import com.surely.surely.dto.promotion.PromotionDTO;
import com.surely.surely.models.EntityMapTo;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

/**
 * Promotion Entity (Father)
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SQLRestriction("deleted = false")
@DiscriminatorColumn(name = "type_promotion", discriminatorType = DiscriminatorType.STRING)
public class Promotion extends EntityMapTo{

	/**
	 * identity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * daleted
	 */
	@Column
	private Boolean deleted = Boolean.FALSE;
	/**
	 * Enabled promotion
	 */
	@Column
	private Boolean enabled = Boolean.FALSE;
	/**
	 * timestamp
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column
	private Date timestamp;

	/**
	 * number of products. example value equal 5 -> "buying 5 quantity of products
	 * or more"
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

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getNumberOfProducts() {
		return numberOfProducts;
	}

	public void setNumberOfProducts(int numberOfProducts) {
		this.numberOfProducts = numberOfProducts;
	}

	@Override
	public Class<?> mapTo() {
		return PromotionDTO.class;
	}

}
