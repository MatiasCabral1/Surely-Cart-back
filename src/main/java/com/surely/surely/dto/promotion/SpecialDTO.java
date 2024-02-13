package com.surely.surely.dto.promotion;

import java.math.BigDecimal;
import java.util.Date;

import com.surely.surely.models.promotion.Special;

/**
 * SpecialDTO
 * 
 * @author Matias
 *
 */
public class SpecialDTO extends PromotionDTO {

	/**
	 * Cash discount
	 */
	private BigDecimal cashDiscount;
	/**
	 * Special Date
	 */
	private Date specialDate;

	public SpecialDTO() {
		super();
	}

	public SpecialDTO(BigDecimal cashDiscount, Date specialDate) {
		super();
		this.cashDiscount = cashDiscount;
		this.specialDate = specialDate;
	}

	public BigDecimal getCashDiscount() {
		return cashDiscount;
	}

	public void setCashDiscount(BigDecimal cashDiscount) {
		this.cashDiscount = cashDiscount;
	}

	public Date getSpecialDate() {
		return specialDate;
	}

	public void setSpecialDate(Date specialDate) {
		this.specialDate = specialDate;
	}

	@Override
	public Class<?> mapTo() {
		return Special.class;
	}

}
