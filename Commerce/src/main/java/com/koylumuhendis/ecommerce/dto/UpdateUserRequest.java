package com.koylumuhendis.ecommerce.dto;


public class UpdateUserRequest {

	private final String firstname;
	private final String lastname;
	private final String address;
	
	
	public UpdateUserRequest(String firstname, String lastname, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	
	public String getAddress() {
		return address;
	}
	public static class builder {
		private String firstname;
		private String lastname;
		private String address;
		
	
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
		
		public UpdateUserRequest build() {
			return new UpdateUserRequest(this);
		}
	}
	
	public UpdateUserRequest(builder builder) {
		this.firstname=builder.firstname;
		this.lastname=builder.lastname;
		this.address=builder.address;
	}
	
	
}
