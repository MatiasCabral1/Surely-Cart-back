package com.surely.surely.controllers.Product;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surely.surely.controllers.cart.CartController;
import com.surely.surely.dto.product.ProductDTO;
import com.surely.surely.services.product.I_ProductService;

@Controller
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	private static final Logger logger = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private I_ProductService productService;

	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() {
		logger.debug("executing ProductController_findAll()");
		Optional<List<ProductDTO>> cart = productService.findAll();
		if (cart != null) {
			return ResponseEntity.ok(cart);
		}
		return ResponseEntity.notFound().build();
	}
}
