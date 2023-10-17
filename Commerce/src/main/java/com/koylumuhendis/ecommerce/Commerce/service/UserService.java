package com.koylumuhendis.ecommerce.Commerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.koylumuhendis.ecommerce.Commerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.Commerce.dto.UpdateUserRequest;
import com.koylumuhendis.ecommerce.Commerce.dto.UserDto;
import com.koylumuhendis.ecommerce.Commerce.dto.UserDtoConverter;
import com.koylumuhendis.ecommerce.Commerce.exception.UserNotFoundException;
import com.koylumuhendis.ecommerce.Commerce.model.User;
import com.koylumuhendis.ecommerce.Commerce.repository.UserRepository;



@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final UserDtoConverter userDtoConverter;

	public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
		this.userRepository = userRepository;
		this.userDtoConverter = userDtoConverter;
	}


	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream()
				.map(userDtoConverter::convert).collect(Collectors.toList());
	}

	public UserDto getUserById(Long id) {
		User user=findById(id);
		return userDtoConverter.convert(user);
	}

	public UserDto createUser(CreateUserRequest userRequest) {
		return userDtoConverter.convert(userRepository.save(userRequest));
	}


	public UserDto updateUser(Long id,UpdateUserRequest updateUserRequest) {
		User user=userRepository.updateUser(id, updateUserRequest.getFirstname(), updateUserRequest.getLastname(), updateUserRequest.getAddress());
		return userDtoConverter.convert(user);
	}
	
	private User findById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->
				new UserNotFoundException("User couldn't be found by following id:"+id));
	}


	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}


	public void deactiveUser(Long id) {
		userRepository.deactiveUser(id);
		
	}
}
	


