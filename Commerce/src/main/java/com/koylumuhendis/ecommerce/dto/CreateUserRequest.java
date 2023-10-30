package com.koylumuhendis.ecommerce.dto;


public class CreateUserRequest {

	private final String firstname;
	private final String lastname;
	private final String mail;
	private final String address;
	
	/*
	 * when using postmapping you have to create constructor
	 * solution of ServletException(type definition error simple type)
	 * */
	
	public CreateUserRequest(String firstname, String lastname, String mail, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.address = address;
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
	
	public static class builder {
		private String firstname;
		private String lastname;
		private String mail;
		private String address;
		
	
		public builder firstname(String firstname) {
			this.firstname=firstname;
			return this;
		}
		public builder lastname(String lastname) {
			this.lastname=lastname;
			return this;
		}
		public builder mail(String mail) {
			this.mail=mail;
			return this;
		}
		public builder address(String address) {
			this.address=address;
			return this;
		}
		
		public CreateUserRequest build() {
			return new CreateUserRequest(this);
		}
	}
	
	public CreateUserRequest(builder builder) {
		this.firstname=builder.firstname;
		this.lastname=builder.lastname;
		this.mail=builder.mail;
		this.address=builder.address;
	}
	
	
}
