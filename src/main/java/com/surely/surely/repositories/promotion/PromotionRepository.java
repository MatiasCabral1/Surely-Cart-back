package com.surely.surely.repositories.promotion;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.promotion.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

	@Query(value = "SELECT * FROM Promotion WHERE type_promotion = :promotionType", nativeQuery = true)
	List<Promotion> findAllByTypePromotion(@Param("promotionType") String promotionType);
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Promotion p WHERE DATE(p.special_date) = CURRENT_DATE AND p.type_promotion = 'SPECIAL'", nativeQuery = true)
	boolean isTodaySpecialDate();


}
