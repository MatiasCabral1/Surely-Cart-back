/**
 * 
 */
package com.surely.surely.models.user;

/**
 * RoleType Enumarative
 * 
 * @author Matias
 *
 */
public enum E_RoleType {
	ADMIN("ADMIN"), 
	SUPERVISOR("SUPERVISOR"), 
	CLIENT("CLIENT");

	private final String description;
	
	/**
	 * Constructor 
	 * 
	 * @param description
	 */
	private E_RoleType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	
}
