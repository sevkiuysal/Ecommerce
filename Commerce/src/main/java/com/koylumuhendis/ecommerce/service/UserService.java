package com.koylumuhendis.ecommerce.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.koylumuhendis.ecommerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.dto.UpdateUserRequest;
import com.koylumuhendis.ecommerce.dto.UserDto;
import com.koylumuhendis.ecommerce.dto.UserDtoConverter;
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

	public UserDto createUser(CreateUserRequest createUserRequest) {
		User user=new User(createUserRequest.getMail(),createUserRequest.getFirstname(),createUserRequest.getLastname(),createUserRequest.getAddress(),true);
		return userDtoConverter.convert(userRepository.save(user));
	}

	@Transactional
	public UserDto updateUser(Long id,UpdateUserRequest updateUserRequest) {
		findUserById(id);
		
		userRepository.updateUser(
				id, 
				updateUserRequest.getFirstname(),
				updateUserRequest.getLastname(),
				updateUserRequest.getAddress());
		return userDtoConverter.convert(findUserById(id));
	}
	
	@Transactional
	public String deleteUser(Long id) {
		findUserById(id);
		if(userRepository.userDeleteById(id))
			return String.format("User with ID= %d has been delete", id);
		return String.format("User with ID= %d hasn't been delete", id);
		
	}
	
	@Transactional
	public void deactiveteUser(Long id) {
		findUserById(id);
		userRepository.deactiveteById(id);
		
	}
	private User findUserById(Long id) {
		return userRepository.findById(id)
				.orElseThrow(()->
				new UserNotFoundException("User couldn't be found by following id:"+id));
	}


	
}
	


