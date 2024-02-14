package com.surely.surely.dto.promotion;

import java.util.Date;

import com.surely.surely.models.promotion.General;

/**
 * General DTO
 * 
 * @author Matias
 *
 */
public class GeneralDTO extends PromotionDTO {

	/**
	 * start date
	 */
	private Date start;
	/**
	 * End Date
	 */
	private Date end;
	/**
	 * discount Percentage
	 */
	private int discountPercentage;// example: 10, 15, 80

	public GeneralDTO() {
		super();
	}

	public GeneralDTO(Date start, Date end, int discountPercentage) {
		super();
		this.start = start;
		this.end = end;
		this.discountPercentage = discountPercentage;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	@Override
	public Class<General> mapTo() {
		return General.class;
	}

}
