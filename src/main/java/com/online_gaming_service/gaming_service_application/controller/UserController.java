package com.online_gaming_service.gaming_service_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.online_gaming_service.gaming_service_application.dto.RegisterUserRequestDTO;
import com.online_gaming_service.gaming_service_application.dto.RegisterUserResponseDTO;
import com.online_gaming_service.gaming_service_application.dto.ResponseDTO;
import com.online_gaming_service.gaming_service_application.dto.ResponseStatusCode;
import com.online_gaming_service.gaming_service_application.entities.User;
import com.online_gaming_service.gaming_service_application.services.UserService;

@RestController
public class UserController {
	
    @Autowired
    private UserService userService;
	
	
    // SignUp Call
	@PostMapping(path="/users")
	public ResponseDTO<RegisterUserResponseDTO> registerUser(@RequestBody RegisterUserRequestDTO request) {
		System.out.println("Lets startttttt" + request);
		System.out.println("Params are" + request.getPhoneNumber() + request.getName());
		User user = userService.registerUser(
                request.getName(),
                request.getPhoneNumber(),
                request.getPassword()
        );
		
		ResponseDTO<RegisterUserResponseDTO> response = new ResponseDTO<>();
		
        if (user == null) {
            response.setStatusCode(ResponseStatusCode.FAILURE);
            return response;
        }
        
        response.setStatusCode(ResponseStatusCode.SUCCESS);
        RegisterUserResponseDTO responseDTO = new RegisterUserResponseDTO();
        responseDTO.setUserId(user.getId());
        response.setData(responseDTO);
        return response;
	}
}
