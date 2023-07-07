package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank extends BaseEntity{
	
	@Column(name="fname",length = 20)
	private String firstName;
	@Column(name="lname",length = 20)
	private String lastName;
	@Column(length = 20)
	private String email;
	@Column(length = 20)
	private String password;
	@Enumerated(EnumType.STRING)
	private AccountType type;
	
	
	public Bank() {
		super();
	}


	public Bank(String firstName, String lastName, String email, String password, AccountType type) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.type = type;
	}


	@Override
	public String toString() {
		return "Bank [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", type=" + type + "]";
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public AccountType getType() {
		return type;
	}


	public void setType(AccountType type) {
		this.type = type;
	}
	
	

}
