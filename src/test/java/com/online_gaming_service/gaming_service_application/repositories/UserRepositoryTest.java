package com.online_gaming_service.gaming_service_application.repositories;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void existsByPhoneNumber() {
		Long phoneNumber = Long.parseLong("1234");

		Boolean actualResult = userRepository.existsByPhoneNumber(phoneNumber);
		String resultString = "false";
		if (actualResult) {
			resultString = "true";
		}
		assertEquals(resultString, "false");
	}

	@AfterEach
	void tearDown() {
		System.out.println("Tearing Down");
	}

	@BeforeEach
	void setUp() {
		System.out.println("Setting Up");
	}
}
