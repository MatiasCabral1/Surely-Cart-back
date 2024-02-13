/**
 * 
 */
package com.surely.surely.models.promotion;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.Where;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.SpecialDTO;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Special Date Promotion Entity
 */
@Entity
@DiscriminatorValue("SPECIAL")
@Where(clause = "deleted = false")
public class Special extends Promotion {

	/**
	 * Cash discount
	 */
	@Column
	private BigDecimal cashDiscount;
	/**
	 * Special Date
	 */
	@Column
	private Date specialDate;

	public Special() {
		super();
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
		return SpecialDTO.class;
	}

}
