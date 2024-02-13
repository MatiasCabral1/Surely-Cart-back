package com.surely.surely.dto.promotion;

import java.math.BigDecimal;
import java.util.Date;

import com.surely.surely.models.promotion.VIP;

/**
 * VIP DTO
 * 
 * @author Matias
 *
 */
public class VIPDTO extends PromotionDTO {
	
	/**
	 * Start Date
	 */
	private Date start;
	/**
	 * End Date
	 */
	private Date end;
	/**
	 * Cash Discount
	 */
	private BigDecimal cashDiscount;
	/**
	 * discount for the cheap product
	 */
	private Boolean discountCheapProduct = Boolean.TRUE;

	public VIPDTO(Date start, Date end, BigDecimal cashDiscount, Boolean discountCheapProduct) {
		super();
		this.start = start;
		this.end = end;
		this.cashDiscount = cashDiscount;
		this.discountCheapProduct = discountCheapProduct;
	}

	public VIPDTO() {
		super();
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

	public BigDecimal getCashDiscount() {
		return cashDiscount;
	}

	public void setCashDiscount(BigDecimal cashDiscount) {
		this.cashDiscount = cashDiscount;
	}

	public Boolean getDiscountCheapProduct() {
		return discountCheapProduct;
	}

	public void setDiscountCheapProduct(Boolean discountCheapProduct) {
		this.discountCheapProduct = discountCheapProduct;
	}

	@Override
	public Class<?> mapTo() {
		return VIP.class;
	}

}
