package com.surely.surely.services.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.surely.surely.dto.cart.CartItemDTO;
import com.surely.surely.models.cart.CartItem;
import com.surely.surely.repositories.cart.CartItemRepository;
import com.surely.surely.services.AbstractService;

@Service
public class CartItemService extends AbstractService<CartItem, Long, CartItemDTO> implements I_CartItemService{

	@Autowired
	CartItemRepository cartItemRepository;
	
	@Override
	public JpaRepository<CartItem, Long> getRepository() {
		return cartItemRepository;
	}

}
