package com.surely.surely.models.user;

import java.util.Date;

import org.hibernate.annotations.Where;

import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.models.EntityMapTo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User Entity
 * 
 * @author Matias
 */
@Entity
@Table(name = "users")
@Where(clause = "deleted = false AND enabled = true")
public class User extends EntityMapTo {

	/**
	 * identity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * deleted
	 */
	@Column
	private Boolean deleted;

	/**
	 * creation timestamp
	 */
	@Column
	private Date timestamp;

	/**
	 * enabled user
	 */
	@Column
	private Boolean enabled = Boolean.FALSE;

	/**
	 * username user
	 */
	@Column
	private String username;

	/**
	 * password user
	 */
	@Column
	private String password;// persist hasheado

	/**
	 * document type
	 */
	@Column
	@Enumerated(EnumType.STRING)
	private E_DocumentType documentType;

	/**
	 * document number
	 */
	@Column
	private String documentNumber;

	/**
	 * role type
	 */
	@Column
	private E_RoleType roleType;

	/**
	 * is VIP User
	 */
	@Column
	private Boolean isVip = Boolean.FALSE;

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
		return UserDTO.class;
	}

}
