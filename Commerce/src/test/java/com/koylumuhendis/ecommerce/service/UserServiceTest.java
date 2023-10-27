package com.koylumuhendis.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.koylumuhendis.ecommerce.dto.UserDto;
import com.koylumuhendis.ecommerce.dto.UserDtoConverter;
import com.koylumuhendis.ecommerce.model.User;
import com.koylumuhendis.ecommerce.repository.UserRepository;

@WebMvcTest(UserService.class)
class UserServiceTest {

	@MockBean
	private UserRepository userRepository;
	@MockBean
	private UserDtoConverter userDtoConverter;
	
	
	
	
	@Test
	void itShouldGetAllUsers() {
		UserDto user1=new UserDto("firstname", "lastname", "mail", "address", true);
		UserDto user2=new UserDto("firstname2", "lastname2", "mail2", "address2", true);
		UserDto user3=new UserDto("firstname3", "lastname3", "mail3", "address3", true);
		List<UserDto> expected=Arrays.asList(user1,user2,user3);
		User u1=new User("mail", "firstname", "lastname", "address", true);
		User u2=new User("mail2", "firstname2", "lastname2", "address2", true);
		User u3=new User("mail3", "firstname3", "lastname3", "address3", true);
		List<User> users=Arrays.asList(u1,u2,u3);
		
		
		when(userRepository.findAll()).thenReturn(users);
		when(userDtoConverter.convertList(users)).thenReturn(expected);
		
		List<UserDto> actual=userDtoConverter.convertList(userRepository.findAll());
		
		assertEquals(expected.get(0).getMail(), actual.get(0).getMail());
		assertEquals(expected.size(), actual.size());
		assertEquals("address3", actual.get(2).getAddress());
	}
	@Test
	void test() {
		
	}
}
