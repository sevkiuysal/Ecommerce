package com.koylumuhendis.ecommerce.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.koylumuhendis.ecommerce.model.User;


@Component
public class UserDtoConverter {
	
	public UserDto convert(User from) {
		return new UserDto(from.getFirstname(),
				from.getLastname(),
				from.getMail(),
				from.getAddress(),
				from.getActive());
	}
	public List<UserDto> convertList(List<User> from) {
		return from.stream()
				.map(user -> convert(user))
				.collect(Collectors.toList());
	}

}
