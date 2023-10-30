package com.koylumuhendis.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.koylumuhendis.ecommerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.dto.UpdateUserRequest;
import com.koylumuhendis.ecommerce.dto.UserDto;
import com.koylumuhendis.ecommerce.dto.UserDtoConverter;
import com.koylumuhendis.ecommerce.exception.UserNotFoundException;
import com.koylumuhendis.ecommerce.model.User;
import com.koylumuhendis.ecommerce.repository.UserRepository;

@WebMvcTest(UserService.class)
class UserServiceTest {

	@MockBean
	private UserRepository userRepository;
	@MockBean
	private UserDtoConverter userDtoConverter;
	@InjectMocks
	private UserService userService;
	
	@Test
	void itShouldGetAllUsers() {
		UserDto user1=new UserDto.builder()
				.firstname("firstname1")
				.lastname("lastname1")
				.build();
		UserDto user2=new UserDto.builder()
				.firstname("firstname2")
				.lastname("lastname2")
				.build();
		UserDto user3=new UserDto.builder()
				.firstname("firstname3")
				.lastname("lastname3")
				.build();
		
		List<UserDto> expected=Arrays.asList(user1,user2,user3);
		User u1=new User.builder()
				.firstname("firstname1")
				.lastname("lastname1")
				.build();
		User u2=new User.builder()
				.firstname("firstname2")
				.lastname("lastname2")
				.build();
		User u3=new User.builder()
				.firstname("firstname3")
				.lastname("lastname3")
				.build();
		List<User> users=Arrays.asList(u1,u2,u3);
		
		
		when(userRepository.findAll()).thenReturn(users);
		when(userDtoConverter.convertList(users)).thenReturn(expected);
		
		List<UserDto> actual=userDtoConverter.convertList(userRepository.findAll());
		
		assertEquals(expected.get(0).getMail(), actual.get(0).getMail());
		assertEquals(expected.size(), actual.size());
		assertEquals("lastname3", actual.get(2).getLastname());
	}
	@Test
	void itShouldUserbyGivenId_whenUserExist() {
		Long id=1L;
		User user=new User.builder()
				.firstname("firstname")
				.address("address")
				.build();
		UserDto expected=new UserDto.builder()
				.firstname("firstname")
				.address("address")
				.build();
		
		when(userRepository.findById(id)).thenReturn(Optional.of(user));
		when(userDtoConverter.convert(user)).thenReturn(expected);
		
		
		UserDto actual=userDtoConverter.convert(user);
		assertEquals(expected, actual);
		
		
	}
	@Test
	void itReturnUserNotFoundException_whenUserNotExist() {
		
		when(userRepository.findById(anyLong())).thenReturn(Optional.empty());
		
		assertThrows(UserNotFoundException.class, () -> userService.getUserById(anyLong()));
	}
	@Test
	void itShouldCreateUser_whenGivenCreateUserRequest() {
		CreateUserRequest request=new CreateUserRequest.builder()
				.firstname("firstname")
				.address("address")
				.build();
		UserDto response=new UserDto.builder()
				.firstname("firstname1")
				.address("address")
				.build();
		User user=new User.builder()
				.firstname(request.getFirstname())
				.address(request.getAddress())				
				.build();
		User createUser=new User.builder()
				.firstname("firstname")
				.address("address")
				.build();
		
		when(userRepository.save(user)).thenReturn(createUser);
		when(userDtoConverter.convert(createUser)).thenReturn(response);
		
		UserDto actual=userDtoConverter.convert(userRepository.save(user));
		assertEquals(response, actual);
		assertEquals("firstname1", actual.getFirstname());
		
	}
	@Test
	void itShouldUpdateUser_whenGivenIdAndUpdateUserRequest() {
		Long id=1L;
		UpdateUserRequest request=new UpdateUserRequest.builder()
				.firstname("firstname")
				.lastname("lastname")
				.address("address")
				.build();
		User user=new User.builder()
				.id(id)
				.build();
		User expected=new User.builder()
				.id(id)
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.address(request.getAddress())
				.build();
		
		when(userRepository.save(user)).thenReturn(expected);
		doNothing().when(userRepository).updateUser(isA(Long.class),isA(String.class),isA(String.class),isA(String.class));
		
		userService.updateUser(id, request);
		
		verify(userRepository).updateUser(id, request.getFirstname(), request.getLastname(), request.getAddress());
	}
}
