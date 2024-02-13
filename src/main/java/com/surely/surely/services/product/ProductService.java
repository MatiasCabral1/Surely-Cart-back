package com.surely.surely.services.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.models.product.Product;
import com.surely.surely.repositories.product.ProductRepository;
import com.surely.surely.services.AbstractService;

@Service
public class ProductService extends AbstractService<Product, Long, ProductDTO> implements I_ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public JpaRepository<Product, Long> getRepository() {
		return productRepository;
	}
	
	public List<ProductDTO> findTopExpensiveProductsByUserId(Long userId) {
	    List<Product> products = this.productRepository.findTopExpensiveProductsByUserId(userId, PageRequest.of(0, 4));
	    return products.stream().map(this::mapEntityToDTO).collect(Collectors.toList());
	}


}
