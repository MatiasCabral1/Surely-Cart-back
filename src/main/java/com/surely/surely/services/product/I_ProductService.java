package com.surely.surely.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.models.product.Product;
import com.surely.surely.services.I_AbstractService;

@Service
public interface I_ProductService  extends I_AbstractService<Product, Long, ProductDTO>{
	
	public List<ProductDTO> findTopExpensiveProductsByUserId(Long userId);

}
