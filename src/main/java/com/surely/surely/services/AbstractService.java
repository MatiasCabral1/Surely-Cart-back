/**
 * 
 */
package com.surely.surely.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.surely.surely.dto.DTOtoEntity;
import com.surely.surely.models.EntityMapTo;

/**
 * Abstract Service
 */
public abstract class AbstractService<T, ID, DTO> implements I_AbstractService<T, ID, DTO> {

	@Autowired
	 private DozerBeanMapper dozerBeanMapper;
	
	@Override
	public Optional<List<DTO>> findAll() {
		List<T> list = this.getRepository().findAll();
		return Optional.of((List<DTO>) list.stream().map(e -> mapEntityToDTO(e)).collect(Collectors.toList()));
		
	}

	@Override	
	public Optional<DTO> findById(ID id) {
		Optional<T> entity = this.getRepository().findById(id);
		return entity.isPresent() 
				? mapEntityToDTO(entity)
				: Optional.empty();
	}
	
	@Override
	public Optional<DTO> save(DTO dto) {
		T entity = mapDTOtoEntity(dto);
		return Optional.of((DTO) mapEntityToDTO(this.getRepository().save(entity)));
	}

	@Override
	public void deleteById(ID id) {
		this.getRepository().deleteById(id);
	}
	
	/**
	 * @param entity
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public DTO mapEntityToDTO(T entity) {
		return (DTO) dozerBeanMapper.map(entity, ((EntityMapTo)entity).mapTo());
	}
	
	/**
	 * @param dto
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public T mapDTOtoEntity(DTO dto) {
		return (T) dozerBeanMapper.map(dto, ((DTOtoEntity)dto).mapTo());
	}
	
	/**
	 * @param entity
	 * @return
	 */
	public Optional<DTO> mapEntityToDTO(Optional<T> entity) {
		return entity.isPresent() ? Optional.of(mapEntityToDTO(entity.get())) : Optional.empty();
	}
	
	/**
	 * @param dto
	 * @return
	 */
	public Optional<T> mapDTOtoEntity(Optional<DTO> dto) {
		return dto.isPresent() ? Optional.of(mapDTOtoEntity(dto.get())) : Optional.empty();
	}

}
