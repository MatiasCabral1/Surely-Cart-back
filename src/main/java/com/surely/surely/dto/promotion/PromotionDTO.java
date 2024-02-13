package com.surely.surely.dto.promotion;

import java.util.Date;

import com.surely.surely.dto.AbstractDTO;
import com.surely.surely.models.promotion.Promotion;

/**
 * Promotion DTO
 * 
 * @author Matias
 *
 */
public class PromotionDTO extends AbstractDTO {

	/**
	 * type_promotion
	 */
	private String type_promotion;
	/**
	 * enabled
	 */
	private Boolean enabled = Boolean.FALSE;
	/**
	 * timestamp
	 */
	private Date timestamp;

	/**
	 * number of products. example value equal 5 -> "buying 5 quantity of products
	 * or more"
	 */
	private int numberOfProducts;

	@Override
	public Class<?> mapTo() {
		return Promotion.class;
	}

	public PromotionDTO() {
		super();
	}

	public PromotionDTO(String type_promotion, Boolean enabled, Date timestamp, int numberOfProducts) {
		super();
		this.type_promotion = type_promotion;
		this.enabled = enabled;
		this.timestamp = timestamp;
		this.numberOfProducts = numberOfProducts;
	}

	public String getType_promotion() {
		return type_promotion;
	}

	public void setType_promotion(String type_promotion) {
		this.type_promotion = type_promotion;
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

}
