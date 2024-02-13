package com.surely.surely.controllers.User;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.surely.surely.dto.user.UserDTO;
import com.surely.surely.services.user.I_UserService;

@Controller
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private I_UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> login(@RequestBody String documentNumber) {
		logger.debug("executing CartController_payCart()");
		Optional<UserDTO> user = userService.findByDocumentNumber(documentNumber);
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		}
		return ResponseEntity.notFound().build();
	}
}
