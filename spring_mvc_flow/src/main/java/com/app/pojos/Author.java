package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


//4.1 Author :id first name ,last name , email(unique) , pwd + ???????
@Entity
@Table(name="auth")
public class Author extends BaseEntity{
	
	@Column(name="fname",length=20)
	private String firstName;
	@Column(name="lname",length=20)
	private String lastName;
	@Column(length=20,unique = true)
	private String email;
	@Column(length=15,nullable = false)
	private String password;
	@OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	private List<Book> booklist = new ArrayList<Book>();
	
	public Author() {
		super();
	}

	public Author(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Author [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
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

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}
	
	public void addNewBook(Book b) {
		booklist.add(b);
		b.setAuthor(this);
	}
	
	public void deleteBook(Book b) {
		booklist.remove(b);
		b.setAuthor(null);
	}

	

	
	

}
