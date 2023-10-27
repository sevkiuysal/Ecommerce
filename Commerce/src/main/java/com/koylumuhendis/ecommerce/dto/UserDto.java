package com.koylumuhendis.ecommerce.dto;

import java.util.Objects;

public class UserDto {

	private String firstname;
	private String lastname;
	private String mail;
	private String address;
	private Boolean isactive;

	public UserDto(String firstname, String lastname, String mail, String address, Boolean isactive) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.address = address;
		this.isactive = isactive;
	}



	public UserDto() {
	}



	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getMail() {
		return mail;
	}

	public String getAddress() {
		return address;
	}


}
