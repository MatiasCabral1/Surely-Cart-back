package com.surely.surely.models.cart;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Where;

import com.surely.surely.dto.cart.CartDTO;
import com.surely.surely.models.EntityMapTo;
import com.surely.surely.models.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * Cart Entity class
 * 
 * @author Matias
 *
 */
@Entity
@Where(clause = "deleted = false")
public class Cart extends EntityMapTo {

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
	private Boolean deleted = Boolean.FALSE;

//	@Column
//	private Boolean enabled = Boolean.TRUE;

	/**
	 * cart status
	 */
	@Column
	@Enumerated(EnumType.STRING)
	private E_CartStatus status;

	/**
	 * creation timestamp
	 */
	@Column
	private Date timestamp;

	/**
	 * user owner
	 */
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	/**
	 * total price
	 */
	@Column
	private BigDecimal price = new BigDecimal("0");

	/**
	 * cart items
	 */
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;

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

	public E_CartStatus getStatus() {
		return status;
	}

	public void setStatus(E_CartStatus status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Class<?> mapTo() {
		// TODO Auto-generated method stub
		return CartDTO.class;
	}

}
