package com.online_gaming_service.gaming_service_application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.repositories.UserRepository;

@Service
public class UserService {

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Autowired
	UserRepository userRepository;

	public User registerUser(String firstName, String lastName, Long phoneNumber, Integer age) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPhoneNumber(phoneNumber);
		user.setAge(age);
		User userResponse = userRepository.save(user);
		return userResponse;

	}

	public boolean userExist(Long phoneNumber) {
		return userRepository.existsByPhoneNumber(phoneNumber);
	}
	
	public User loginUser(Long phoneNumber) {
		Optional<User> userResponse = userRepository.findByPhoneNumber(phoneNumber);
		if (userResponse.isEmpty()) {
			return null;
		}
		return userResponse.get();
	}
}