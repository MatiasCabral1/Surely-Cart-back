/**
 * 
 */
package com.surely.surely.models.product;


/**
 * role type enumerative
 */
public enum E_ProductCategory {
	TECHNOLOGY("TECHNOLOGY"), HOME("HOME"), SPORT("SPORT"), TOOL("TOOL");
	
	private final String description;

	public String getDescription() {
		return description;
	}

	private E_ProductCategory(String description) {
		this.description = description;
	}
}
