package com.koylumuhendis.ecommerce.dto;

import java.util.Objects;

import com.koylumuhendis.ecommerce.model.User;
import com.koylumuhendis.ecommerce.model.User.builder;

public class UserDto {

	private final String firstname;
	private final String lastname;
	private final String mail;
	private final String address;
	private final Boolean isactive;

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

	public static class builder {
		private String mail;
		private String firstname;
		private String lastname;
		private String address;
		private Boolean isactive;
		
	
		public builder mail(String mail) {
			this.mail=mail;
			return this;
		}
		public builder firstname(String firstname) {
			this.firstname=firstname;
			return this;
		}
		public builder lastname(String lastname) {
			this.lastname=lastname;
			return this;
		}
		public builder address(String address) {
			this.address=address;
			return this;
		}
		public builder isactive(Boolean isactive) {
			this.isactive=isactive;
			return this;
		}
		public UserDto build() {
			return new UserDto(this);
		}
	}
	
	public UserDto(builder builder) {
		this.mail=builder.mail;
		this.firstname=builder.firstname;
		this.lastname=builder.lastname;
		this.address=builder.address;
		this.isactive=builder.isactive;
	}

}
