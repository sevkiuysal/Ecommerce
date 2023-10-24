package com.koylumuhendis.ecommerce.Commerce.dto;

import org.springframework.stereotype.Component;

import com.koylumuhendis.ecommerce.Commerce.model.User;


@Component
public class UserDtoConverter {
	
	public UserDto convert(User from) {
		return new UserDto(from.getFirstname(),
				from.getLastname(),
				from.getMail(),
				from.getAddress(),
				from.getActive());
	}

}
