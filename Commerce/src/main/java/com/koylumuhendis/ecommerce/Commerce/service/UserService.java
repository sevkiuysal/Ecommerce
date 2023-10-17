package com.koylumuhendis.ecommerce.Commerce.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.koylumuhendis.ecommerce.Commerce.model.User;
import com.koylumuhendis.ecommerce.Commerce.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
}
	

}
