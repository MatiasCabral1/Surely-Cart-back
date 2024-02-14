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
import com.surely.surely.repositories.promotion.GeneralRepository;
import com.surely.surely.repositories.promotion.VipRepository;
import com.surely.surely.repositories.promotion.PromotionRepository;
import com.surely.surely.repositories.promotion.SpecialRepository;
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
	
	@Autowired
	private SpecialRepository specialRepository;
	
	@Autowired
	private VipRepository vipRepository;
	
	@Autowired
	private GeneralRepository generalRepository;

	private CartStrategy cartStrategy;

	@Override
	public void applyDiscount(CartDTO cart) {
		E_PromotionType promotionType = cart.getUser().getIsVip() ? E_PromotionType.VIP
				: specialRepository.isTodaySpecialDate() ? E_PromotionType.SPECIAL : null;
		// If the cart is general then the discount does not apply.
		if (promotionType != null) {
			List<PromotionDTO> commonPromotions = this.findByTypePromotion(E_PromotionType.GENERAL);
			List<PromotionDTO> otherPromotions = this.findByTypePromotion(promotionType);
			this.setCartStrategy(StrategyFactory.createCartStrategy(promotionType));
			this.getCartStrategy().applyPromotion(cart, commonPromotions, otherPromotions);
		}

	}

	public List<PromotionDTO> findByTypePromotion(E_PromotionType promotionType) {
	    List<? extends Promotion> list;
	    switch (promotionType) {
	        case SPECIAL: 
	            list = specialRepository.findAll();
	            break;
	        case VIP:
	            list = vipRepository.findAll();
	            break;
	        default:
	            list = generalRepository.findAll();
	    }
	    return list.stream().map(this::mapEntityToDTO).collect(Collectors.toList());
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
