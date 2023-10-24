package com.koylumuhendis.ecommerce.Commerce.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koylumuhendis.ecommerce.Commerce.dto.CreateUserRequest;
import com.koylumuhendis.ecommerce.Commerce.dto.UpdateUserRequest;
import com.koylumuhendis.ecommerce.Commerce.dto.UserDto;
import com.koylumuhendis.ecommerce.Commerce.service.UserService;

@RestController
@RequestMapping("/v1/user")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@GetMapping("/getBy/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id){
		return ResponseEntity.ok(userService.getUserById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest userRequest){
		return ResponseEntity.ok(userService.createUser(userRequest));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updateUser(
			@PathVariable Long id,
			@RequestBody UpdateUserRequest updateUserRequest){
		
		userService.updateUser(id,updateUserRequest);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	@PatchMapping("/deactivete/{id}")
	public ResponseEntity<Void> deactiveteUser(@PathVariable("id") Long id){
		userService.deactiveteUser(id);
		return ResponseEntity.ok().build();
	}


}
