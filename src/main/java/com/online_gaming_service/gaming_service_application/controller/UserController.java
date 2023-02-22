package com.online_gaming_service.gaming_service_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.online_gaming_service.gaming_service_application.dto.RegisterUserRequestDTO;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	// SignUp Call
	@PostMapping(path = "/register/user")
	public ResponseEntity<String> registerUser(@RequestBody RegisterUserRequestDTO registerUserRequest) {

		try {
			if (registerUserRequest.getPhoneNumber() == null || registerUserRequest.getFirstName() == null || registerUserRequest.getFirstName().isBlank()) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Phone Number and First name are mandatory fields to register the user. Please provide them.");
			} else if (userService.userExist(registerUserRequest.getPhoneNumber())) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("User with the given phone number already exist. Please try with login");
			}
			User user = userService.registerUser(registerUserRequest.getFirstName(), registerUserRequest.getLastName(),
					registerUserRequest.getPhoneNumber(), registerUserRequest.getAge());

			if (user == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("User didn't get registered. Please Try again");
			}

			return ResponseEntity.status(HttpStatus.OK).body("User get Registered with Phone Number "
					+ user.getPhoneNumber() + " And User id is " + user.getId());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Got exception " + e.getMessage() + " Please try again by giving proper Values");
		}
	}
}
