package com.surely.surely.services.promotion;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.dto.promotion.PromotionDTO;
import com.surely.surely.models.promotion.E_PromotionType;
import com.surely.surely.models.promotion.Promotion;
import com.surely.surely.repositories.promotion.PromotionRepository;
import com.surely.surely.services.AbstractService;
import com.surely.surely.strategies.CartStrategy;
import com.surely.surely.strategies.StrategyFactory;

/**
 * Promotion service
 * 
 * @author Matias
 *
 */
@Service
public class PromotionService extends AbstractService<Promotion, Long, PromotionDTO> implements I_PromotionService {

	@Autowired
	private PromotionRepository promotionRepository;

	private CartStrategy cartStrategy;

	@Override
	public void applyDiscount(CartDTO cart) {
		E_PromotionType promotionType = cart.getUser().getIsVip() ? E_PromotionType.VIP
				: promotionRepository.isTodaySpecialDate() ? E_PromotionType.SPECIAL : null;
		// If the cart is common then the discount does not apply.
		if (promotionType != null) {
			List<PromotionDTO> commonPromotions = this.findAllByTypePromotion(E_PromotionType.GENERAL.getDescription());
			List<PromotionDTO> otherPromotions = this.findAllByTypePromotion(promotionType.getDescription());
			this.setCartStrategy(StrategyFactory.createCartStrategy(promotionType));
			this.getCartStrategy().applyPromotion(cart, commonPromotions, otherPromotions);
		}

	}

	public List<PromotionDTO> findAllByTypePromotion(String promotionType) {
		List<Promotion> list = promotionRepository.findAllByTypePromotion(promotionType);
		return (List<PromotionDTO>) list.stream().map(e -> mapEntityToDTO(e)).collect(Collectors.toList());
	}

	public CartStrategy getCartStrategy() {
		return cartStrategy;
	}

	public void setCartStrategy(CartStrategy cartStrategy) {
		this.cartStrategy = cartStrategy;
	}

	@Override
	public JpaRepository<Promotion, Long> getRepository() {
		return promotionRepository;
	}

}
