package com.surely.surely.strategies;

import java.math.BigDecimal;
import java.util.List;


import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.GeneralDTO;
import com.surely.surely.dto.promotion.PromotionDTO;

/**
 * Cart Strategy
 * 
 * @author Matias
 *
 */
public interface CartStrategy {

	
	public void applyDiscount(CartDTO cart,List<PromotionDTO> otherPromotions);

	/**
	 * Common discount will be used for promotions of type Vip  or special.
	 * 
	 * @param cart
	 * @param commonPromotions
	 */
	public default void generalDiscount(CartDTO cart, List<PromotionDTO> commonPromotions) {	
	    for (PromotionDTO optionalPromotion : commonPromotions) {
	        GeneralDTO commonPromotion = (GeneralDTO) optionalPromotion;
	        if (cart.getNumberOfProducts() == commonPromotion.getNumberOfProducts()) {
	            BigDecimal discountPercentage = BigDecimal.valueOf(commonPromotion.getDiscountPercentage()).divide(BigDecimal.valueOf(100));
	            BigDecimal discountAmount = cart.getPrice().multiply(discountPercentage);
	            BigDecimal newPrice = cart.getPrice().subtract(discountAmount);
	            cart.setPrice(newPrice);
	        }
	    }
	}

	
	/**
	 * this method will apply 
	 * @param cart
	 * @param promoRepo
	 */
	public default void applyPromotion(CartDTO cart, List<PromotionDTO>  commonPromotions, List<PromotionDTO> otherPromotions) {
		this.generalDiscount(cart, commonPromotions);
		this.applyDiscount(cart, otherPromotions);
	}
}
