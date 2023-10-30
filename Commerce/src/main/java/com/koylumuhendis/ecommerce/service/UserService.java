package com.koylumuhendis.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.koylumuhendis.ecommerce.dto.*;
import com.koylumuhendis.ecommerce.exception.UserNotFoundException;
import com.koylumuhendis.ecommerce.model.User;
import com.koylumuhendis.ecommerce.repository.UserRepository;

import jakarta.transaction.Transactional;



@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final UserDtoConverter userDtoConverter;

	public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
		this.userRepository = userRepository;
		this.userDtoConverter = userDtoConverter;
	}


	public List<UserDto> getAllUsers() {
		return userDtoConverter.convertList(userRepository.findAll());
	}

	public UserDto getUserById(Long id) {
		User user=findUserById(id);
		return userDtoConverter.convert(user);
	}

	public UserDto createUser(CreateUserRequest request) {
		User user=new User.builder()
				.mail(request.getMail())
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.address(request.getAddress())
				.build();
		return userDtoConverter.convert(userRepository.save(user));
	}

	@Transactional
	public void updateUser(Long id,UpdateUserRequest updateUserRequest) {
		userRepository.updateUser(
				id, 
				updateUserRequest.getFirstname(),
				updateUserRequest.getLastname(),
				updateUserRequest.getAddress());
		
	}
	
	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);		
	}
	
	@Transactional
	public void deactiveteUser(Long id) {
		findUserById(id);
		userRepository.deactiveteById(id);
		
	}
	private User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->
				new UserNotFoundException());
	}


	
}
	


