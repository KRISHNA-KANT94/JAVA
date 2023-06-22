package com.app.pojos;

import javax.persistence.*;

//Book : id,title(unique), price + ?????
@Entity
@Table(name="book")
public class Book extends BaseEntity {
	
	@Column(unique = true,length=20)
	private String title;
	private double price;
	@ManyToOne
	private Author author;
	
	public Book() {
		super();
	}

	public Book(String title, double price) {
		super();
		this.title = title;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
	
	
	

}
