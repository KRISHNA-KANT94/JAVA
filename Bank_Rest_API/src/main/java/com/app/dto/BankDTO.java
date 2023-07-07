package com.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.app.entities.AccountType;

public class BankDTO {
	
	private Long id;
	@NotBlank(message = "fname cant be blank")
	private String firstName;
	@NotBlank(message = "lname cant be blank")
	private String lastName;
	@NotBlank(message = "email cant be blank")
	@Email
	private String email;
	@NotBlank(message = "password cant be blank")
	private String password;
	private AccountType type;
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
