package com.surely.surely.services.user;

import java.util.Optional;

import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.models.user.User;
import com.surely.surely.services.I_AbstractService;

public interface I_UserService extends I_AbstractService<User, Long, UserDTO> {

	Optional<UserDTO> findByDocumentNumber(String documentNumber);

}