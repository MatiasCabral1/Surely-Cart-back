package com.surely.surely.services.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.models.user.User;
import com.surely.surely.repositories.user.UserRepository;
import com.surely.surely.services.AbstractService;
import com.surely.surely.utils.CodedException;


@Service
public class UserService extends AbstractService<User, Long, UserDTO> implements I_UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public JpaRepository<User, Long> getRepository() {
		return userRepository;
	}

	@Override
	public Optional<UserDTO> findByDocumentNumber(String documentNumber) {
		Optional<User> user = this.getUserRepository().findByDocumentNumber(documentNumber);
		if (user.isEmpty()) {
			throw new CodedException("Usuario con numero de documento " + documentNumber + ", no encontrado!");
		}
		return mapEntityToDTO(user);
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
