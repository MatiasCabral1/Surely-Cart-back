/**
 * 
 */
package com.surely.surely.models.promotion;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.Where;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.VIPDTO;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * VIP Promotion Entity
 */

@Entity
@DiscriminatorValue("VIP")
@Where(clause = "deleted = false")
public class VIP extends Promotion {

	/**
	 * Start Date
	 */
	@Column(name = "start_date")
	private Date start;
	/**
	 * End Date
	 */
	@Column(name = "end_date")
	private Date end;
	/**
	 * Cash Discount
	 */
	private BigDecimal cashDiscount;
	/**
	 * discount for the cheap product
	 */
	private Boolean discountCheapProduct = Boolean.TRUE;

	public VIP() {
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
		return VIPDTO.class;
	}

}
