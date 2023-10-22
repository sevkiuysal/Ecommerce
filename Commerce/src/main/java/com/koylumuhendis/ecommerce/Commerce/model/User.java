package com.koylumuhendis.ecommerce.Commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="_user")
public class User extends BaseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mail;
	private String firstname;
	private String lastname;
	private String address;
	public User(String mail, String firstname, String lastname, String address) {
		this.mail = mail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
	}
	public User() {
	}
	public Long getId() {
		return id;
	}
	public String getMail() {
		return mail;
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
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
