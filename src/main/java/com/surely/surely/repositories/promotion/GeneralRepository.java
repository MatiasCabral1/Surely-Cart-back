package com.surely.surely.repositories.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.promotion.General;

@Repository
public interface GeneralRepository extends JpaRepository<General, Long>{

}