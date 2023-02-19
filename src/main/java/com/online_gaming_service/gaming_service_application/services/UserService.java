package com.online_gaming_service.gaming_service_application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User registerUser(String name,
			String phoneNumber,
			String password) {
		User user = new User();
		user.setName(name);
		user.setHashedPassword(password);
		user.setPhoneNumber(phoneNumber);

		User userResponse = userRepository.save(user);

		return userResponse;

	}
}