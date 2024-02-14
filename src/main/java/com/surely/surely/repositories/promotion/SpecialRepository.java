package com.surely.surely.repositories.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.promotion.Special;

@Repository
public interface SpecialRepository extends JpaRepository<Special, Long>{
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN TRUE ELSE FALSE END FROM Special p WHERE DATE(p.special_date) = CURRENT_DATE AND", nativeQuery = true)
	boolean isTodaySpecialDate();
}
