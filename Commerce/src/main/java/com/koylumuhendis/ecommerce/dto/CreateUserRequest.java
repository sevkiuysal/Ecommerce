package com.koylumuhendis.ecommerce.dto;



public class CreateUserRequest {

	private String firstname;
	private String lastname;
	private String mail;
	private String address;
	public CreateUserRequest(String firstname, String lastname, String mail, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.mail = mail;
		this.address = address;
	}
	public CreateUserRequest() {
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
