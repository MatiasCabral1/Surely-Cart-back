package com.surely.surely.repositories.promotion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.promotion.VIP;

@Repository
public interface VipRepository extends JpaRepository<VIP, Long>{

}