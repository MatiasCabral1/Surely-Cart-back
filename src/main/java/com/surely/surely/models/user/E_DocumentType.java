package com.surely.surely.models.user;

/**
 * DOCUMENT TYPE, ONLY FOR ARGENTINA
 */
public enum E_DocumentType {
	DU("DU"), LE("LE"), LC("LC"), OTHER("OTHER");
	private final String description;
	
	/**
	 * Constructor
	 * 
	 * @param description
	 */
	private E_DocumentType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

}
