package com.surely.surely.models.promotion;

/**
 * Promotion type enumarative
 * 
 * @author Matias
 *
 */
public enum E_PromotionType {
	VIP("VIP"), GENERAL("GENERAL"), SPECIAL("SPECIAL");
	
	private final String description;

	private E_PromotionType(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

}
