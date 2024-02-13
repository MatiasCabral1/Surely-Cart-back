package com.surely.surely.repositories.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surely.surely.models.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	public Optional<User> findByDocumentNumber(String documentNumber);
}
