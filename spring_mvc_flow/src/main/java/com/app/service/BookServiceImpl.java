package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.app.dao.BookDao;
import com.app.pojos.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookdao;
	@Override
	public List<Book> getAllBook() {
		
		
		return bookdao.getAllBook();
	}

}
