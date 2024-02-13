package com.surely.surely.dto.cart;

/**
 * DTO for addToCardRequest
 * @author Matias
 *
 */
public class AddToCartRequestDTO {
	private Long cartId;
    private Long productId;
    private int quantity;

    // Getters y setters
    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
