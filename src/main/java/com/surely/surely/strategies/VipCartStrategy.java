package com.surely.surely.strategies;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.dto.promotion.PromotionDTO;
import com.surely.surely.dto.promotion.VIPDTO;
/**
 * Vip cart Strategy
 * 
 * @author Matias
 *
 */
public class VipCartStrategy implements CartStrategy {

	private static final Logger logger = LoggerFactory.getLogger(VipCartStrategy.class);	

	@Override
	public void applyDiscount(CartDTO cart, List<PromotionDTO> vipPromotions) {
		logger.debug("executing VipCartStrategy_applyDiscount()");
		Boolean justOneCheapProduct = Boolean.FALSE;
		for (PromotionDTO optionalPromotion : vipPromotions) {
			VIPDTO vipPromotion = (VIPDTO) optionalPromotion;
			if (cart.getNumberOfProducts() >= vipPromotion.getNumberOfProducts()) {
				// apply discount for the most cheap product
				if (vipPromotion.getDiscountCheapProduct() && !justOneCheapProduct) {
					logger.debug("applying cheapProdDiscount");
					cart.setPrice(
							cart.getPrice().subtract(cart.getPrice().min(Optional.ofNullable(cart.getMostCheapProduct())
									.map(ProductDTO::getPrice).orElse(BigDecimal.ZERO))));
					justOneCheapProduct = true;
				}
				// apply general discount
				logger.debug("applying general Discount");
				cart.setPrice(cart.getPrice().subtract(cart.getPrice().min(vipPromotion.getCashDiscount())));
			}
		}
	}

}
