package com.surely.surely.strategies;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.PromotionDTO;
import com.surely.surely.dto.promotion.SpecialDTO;

/**
 * Special Cart Strategy
 * @author Matias
 *
 */
public class SpecialCartStrategy implements CartStrategy{
	
	private static final Logger logger = LoggerFactory.getLogger(SpecialCartStrategy.class);


	@Override
	public void applyDiscount(CartDTO cart, List<PromotionDTO> specialPromotions) {
		logger.debug("executing SpecialCartStrategy_applyDiscount()");
		for (PromotionDTO optionalPromotion : specialPromotions) {
		    SpecialDTO specialPromo = (SpecialDTO)optionalPromotion;
		    if (cart.getNumberOfProducts() >= specialPromo.getNumberOfProducts()) {
		    	logger.debug("applying general Discount");
			    cart.setPrice(cart.getPrice().subtract(cart.getPrice().min(specialPromo.getCashDiscount())));
		    }
		}
	}

}
