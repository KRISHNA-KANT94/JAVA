package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Book;

@Repository
public class BookDaoImpl implements BookDao {
	
	@Autowired
	private SessionFactory sf;

	@Override
	public List<Book> getAllBook() {
		
		
		return sf.getCurrentSession()
				.createQuery("select b from Book b",Book.class)
				.getResultList();
	}

}
