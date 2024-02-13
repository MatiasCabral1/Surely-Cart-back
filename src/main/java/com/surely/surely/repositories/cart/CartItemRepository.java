package com.surely.surely.repositories.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.cart.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
