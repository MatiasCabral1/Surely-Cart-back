package com.surely.surely.services.cart;

import org.springframework.stereotype.Service;

import com.surely.surely.dto.cart.CartItemDTO;
import com.surely.surely.models.cart.CartItem;
import com.surely.surely.services.I_AbstractService;

/**
 * 
 * @author Matias
 *
 */
@Service
public interface I_CartItemService extends I_AbstractService<CartItem, Long, CartItemDTO>{

}
