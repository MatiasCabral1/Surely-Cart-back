package com.surely.surely.repositories.product;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	@Query("SELECT DISTINCT p " +
            "FROM Cart c " +
            "JOIN c.cartItems ci " +
            "JOIN ci.product p " +
            "WHERE c.user.id = :userId " +
            "AND c.status = 'FINISHED' " + 
            "ORDER BY p.price DESC")
List<Product> findTopExpensiveProductsByUserId(@Param("userId") Long userId, Pageable pageable);
}
