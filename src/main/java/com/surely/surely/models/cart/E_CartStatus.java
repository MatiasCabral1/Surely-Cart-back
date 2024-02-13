package com.surely.surely.models.cart;

/**
 * Cart Status Enumarative
 * 
 * @author Matias
 *
 */
public enum E_CartStatus {
    IN_PROCESS("IN_PROCESS"), 
    CANCELLED("CANCELLED"), 
    FINISHED("FINISHED");

    private final String description;

    // Constructor
    E_CartStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}