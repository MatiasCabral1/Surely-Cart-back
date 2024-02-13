package com.surely.surely.strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.surely.surely.models.promotion.E_PromotionType;
import com.surely.surely.utils.CodedException;
import com.surely.surely.utils.GlobalHandlerException;
/**
 * Strategy Factory
 * 
 * @author Matias
 *
 */
public class StrategyFactory {
	private static final Logger logger = LoggerFactory.getLogger(StrategyFactory.class);

	/**
	 * This method returns the strategy received on param 'strat'
	 * 
	 * @param strat
	 * @return
	 * @throws GlobalHandlerException
	 */
	public static CartStrategy createCartStrategy(E_PromotionType strat) throws CodedException {
		logger.debug("executing StrategyFactory_createCartStrategy() with param {}", strat);
		return switch (strat) {
		case SPECIAL -> new SpecialCartStrategy();
		default -> new VipCartStrategy();
		};
	}
}
