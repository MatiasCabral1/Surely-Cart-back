package com.surely.surely.dto.user;

import java.util.Date;

import com.surely.surely.dto.AbstractDTO;
import com.surely.surely.models.user.E_DocumentType;
import com.surely.surely.models.user.E_RoleType;
import com.surely.surely.models.user.User;

/**
 * User DTO
 * 
 * @author Matias
 *
 */
public class UserDTO extends AbstractDTO {
	
	/**
	 * creation timestamp
	 */
	private Date timestamp;
	
	/**
	 * enabled user
	 */
	private Boolean enabled = Boolean.FALSE;
	
	/**
	 * username user
	 */
	private String username;
	
	/**
	 * password user
	 */
	private String password;// persist hasheado
	
	/**
	 * document type
	 */
	private E_DocumentType documentType;
	
	/**
	 * document number
	 */
	private String documentNumber;
	
	/**
	 * role type
	 */
	private E_RoleType roleType;
	
	/**
	 * is VIP User
	 */
	private Boolean isVip = Boolean.FALSE;

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public E_DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(E_DocumentType documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public E_RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(E_RoleType roleType) {
		this.roleType = roleType;
	}

	public Boolean getIsVip() {
		return isVip;
	}

	public void setIsVip(Boolean isVip) {
		this.isVip = isVip;
	}

	@Override
	public Class<?> mapTo() {
		return User.class;
	}

	public UserDTO() {
		super();
	}

	public UserDTO(Date timestamp, Boolean enabled, String username, String password, E_DocumentType documentType,
			String documentNumber, E_RoleType roleType, Boolean isVip) {
		super();
		this.timestamp = timestamp;
		this.enabled = enabled;
		this.username = username;
		this.password = password;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.roleType = roleType;
		this.isVip = isVip;
	}

}
