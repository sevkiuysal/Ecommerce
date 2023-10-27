package com.koylumuhendis.ecommerce.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.koylumuhendis.ecommerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.dto.UpdateUserRequest;
import com.koylumuhendis.ecommerce.dto.UserDto;
import com.koylumuhendis.ecommerce.service.UserService;



@WebMvcTest(UserController.class)
class UserControllerTest {
	@MockBean
	private UserService userService;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper mapper;

	@Test
	void itShouldGetAllUsers() throws Exception {
		List<UserDto> responses=new ArrayList<UserDto>();
		
		when(userService.getAllUsers()).thenReturn(responses);
		
		mockMvc.perform(get("/v1/user/getAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());
	}

	@Test
	void itShouldGetUserbyId_WhenUserExist() throws Exception {
		Long id = 1L;
		UserDto expected = new UserDto("firstname", "lastname", "mail", "address", true);
		
		when(userService.getUserById(id)).thenReturn(expected);
		
		
		mockMvc.perform(get(String.format("/v1/user/getBy/%d", id))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstname").value(expected.getFirstname()))
				.andExpect(status().isOk())
				.andDo(print());

	}


	@Test
	void itShouldCreateUser_WhenGivenCreateUserRequest() throws Exception {
		CreateUserRequest request = new CreateUserRequest("firstname", "lastname", "mail", "address");
		UserDto expected = new UserDto("firstname", "lastname", "mail", "address", true);
		
		when(userService.createUser(request)).thenReturn(expected);

		
		mockMvc.perform(post("/v1/user/create").contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andDo(print());
		
	}

	@Test
	void itShouldUpdateUser_WhenGivenUpdateUserRequest() throws Exception {
		Long id=1L;
		UpdateUserRequest request=new UpdateUserRequest("firstname", "lastname", "address");
		UserDto response=new UserDto("firstname", "lastname", "mail", "address", true);
		
		when(userService.updateUser(id, request)).thenReturn(response);
		
		mockMvc.perform(put(String.format("/v1/user/update/%d", id))
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(request)))
		.andExpect(status().isOk())
		.andDo(print());

		
	}

	@Test
	void itShouldDeleteUserGivenbyId_whenUserExist() throws Exception {
		Long id=1L;
		
		mockMvc.perform(delete(String.format("/v1/user/delete/%d", id))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print());
		
	}

	@Test
	void itShouldDeactiveteUserGivenbyId_whenUserExist() throws Exception {
		Long id=1L;
		mockMvc.perform(patch(String.format("/v1/user/deactivete/%d", id))
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andDo(print());
	}
}