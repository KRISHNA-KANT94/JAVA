package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.BookService;

@Controller
@RequestMapping("/books")
public class BookListController {
	@Autowired
	 private BookService bookservice;
	 
	 public BookListController() {
		System.out.println("in Book List Constructor"+ getClass());
	}
	
	 @GetMapping("/listt")
	public ModelAndView fetchAllBook() {
		System.out.println("in booklist constructor");
		return new ModelAndView("/book/list", "booklist", bookservice.getAllBook());
		
	}

}
