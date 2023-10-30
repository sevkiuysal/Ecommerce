package com.koylumuhendis.ecommerce.model;

import jakarta.persistence.Column;
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
	private final Long id;
	@Column(unique = true)
	private final String mail;
	private final String firstname;
	private final String lastname;
	private final String address;
	private final Boolean isactive;
	
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
	public static class builder {
		private Long id;
		private String mail;
		private String firstname;
		private String lastname;
		private String address;
		private Boolean isactive;
		
		public builder id(Long id) {
			this.id=id;
			return this;
		}
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
		public User build() {
			return new User(this);
		}
	}
	
	public User(builder builder) {
		this.id=builder.id;
		this.mail=builder.mail;
		this.firstname=builder.firstname;
		this.lastname=builder.lastname;
		this.address=builder.address;
		this.isactive=builder.isactive;
	}
}
