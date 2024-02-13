package com.surely.surely.services.promotion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.PromotionDTO;
import com.surely.surely.models.promotion.Promotion;
import com.surely.surely.services.I_AbstractService;

/**
 * Promotion service interface
 * 
 * @author Matias
 *
 */
@Service
public interface I_PromotionService extends I_AbstractService<Promotion, Long, PromotionDTO>{
	
	public void applyDiscount(CartDTO cart);
	
	public List<PromotionDTO> findAllByTypePromotion(String promotionType);
}
