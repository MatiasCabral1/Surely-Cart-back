/**
 * 
 */
package com.surely.surely.models.promotion;

import java.util.Date;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.GeneralDTO;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

/**
 * Default Promotion Entity
 */
@Entity
@DiscriminatorValue("GENERAL")
@Where(clause = "deleted = false")
public class General extends Promotion {
	/**
	 * Start Date
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "start_date")
	private Date start;
	/**
	 * End Date
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Column(name = "end_date")
	private Date end;
	/**
	 * discount Percentage
	 */
	@Column
	private int discountPercentage;// example: 10, 15, 80

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

	public General() {
		super();
	}
	
	@Override
	public Class<?> mapTo() {
		return GeneralDTO.class;
	}
}
