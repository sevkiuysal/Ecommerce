package com.koylumuhendis.ecommerce.model;

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
	private Boolean isactive=true;
	
	public User(String mail, String firstname, String lastname, String address,Boolean isactive) {
		this.mail = mail;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.isactive=isactive;
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
	public Boolean getActive() {
		return isactive;
	}
	

}
