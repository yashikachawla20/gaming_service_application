package com.online_gaming_service.gaming_service_application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.online_gaming_service.gaming_service_application.repositories.UserRepository;
import com.online_gaming_service.gaming_service_application.services.UserService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	private UserService userService;

	@Test
	void userExist() {
		Long phoneNumber = Long.parseLong("123");
		boolean actualResult = userService.userExist(phoneNumber);
		verify(userRepository).existsByPhoneNumber(phoneNumber);
	}

	@BeforeEach
	void setUp() {
		this.userService = new UserService(this.userRepository);
	}
}
