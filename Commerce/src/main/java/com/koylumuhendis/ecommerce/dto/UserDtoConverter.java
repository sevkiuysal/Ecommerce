package com.koylumuhendis.ecommerce.dto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.koylumuhendis.ecommerce.exception.UserNotFoundException;
import com.koylumuhendis.ecommerce.model.User;


@Component
public class UserDtoConverter {
	
	public UserDto convert(User from) {
		return new UserDto.builder()
				.firstname(from.getFirstname())
				.lastname(from.getLastname())
				.mail(from.getMail())
				.address(from.getAddress())
				.isactive(from.getActive())
				.build();
	}
	public List<UserDto> convertList(List<User> from) {
		return from.stream()
				.map(user -> convert(user))
				.collect(Collectors.toList());
	}
	public UserDto convertOptional(Optional<User> from) {
		return convert(from
				.orElseThrow(() -> new UserNotFoundException("User not found!")));
	}

}
