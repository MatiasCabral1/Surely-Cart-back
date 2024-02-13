package com.surely.surely.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface I_AbstractService<T, ID, DTO> {

	public JpaRepository<T, ID> getRepository();
	
	public Optional<List<DTO>> findAll();

	public Optional<DTO> findById(ID id);

	public Optional<DTO>save(DTO entity);

	public void deleteById(ID id);

}
