package com.surely.surely.dto;

/**
 * Abstract DTO
 * 
 * @author Matias
 *
 */
public abstract class AbstractDTO extends DTOtoEntity {
	private Long id;
	private Boolean deleted = Boolean.FALSE;

	public AbstractDTO() {
		super();
	}

	public AbstractDTO(Long id, Boolean deleted) {
		super();
		this.id = id;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

}
