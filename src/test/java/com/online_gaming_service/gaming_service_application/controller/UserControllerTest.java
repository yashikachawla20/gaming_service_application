package com.online_gaming_service.gaming_service_application.controller;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.online_gaming_service.gaming_service_application.dto.RegisterUserRequestDTO;
import com.online_gaming_service.gaming_service_application.services.UserService;

@SpringBootTest
public class UserControllerTest {

	@Autowired
	private UserController userController;

	@Test
	void registerUser() {
		RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
		registerUserRequestDTO.setPhoneNumber(Long.parseLong("12333000"));
		registerUserRequestDTO.setFirstName("Dummy1");
		registerUserRequestDTO.setLastName("Dummy2");
		registerUserRequestDTO.setAge(10);

		ResponseEntity<String> resultEntity = userController.registerUser(registerUserRequestDTO);
		String resultString = "" + resultEntity.getStatusCodeValue();
		assert (resultString).equals("200");
	}

	void registerUserPhoneNumberNotPresent() {
		RegisterUserRequestDTO registerUserRequestDTO = new RegisterUserRequestDTO();
		registerUserRequestDTO.setPhoneNumber(null);
		registerUserRequestDTO.setFirstName("Dummy1");
		registerUserRequestDTO.setLastName("Dummy2");
		registerUserRequestDTO.setAge(10);

		ResponseEntity<String> resultEntity = userController.registerUser(registerUserRequestDTO);
		String resultString = "" + resultEntity.getStatusCodeValue();
		assert (resultString).equals("400");
	}

}
