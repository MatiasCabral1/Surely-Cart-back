package com.surely.surely.repositories.cart;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.cart.Cart;
import com.surely.surely.models.cart.E_CartStatus;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	Optional<Cart> findByUserId(Long userId);
	Optional<Cart> findByUserIdAndStatus(Long userId, E_CartStatus status);

}
