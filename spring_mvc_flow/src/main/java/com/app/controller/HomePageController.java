package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	
	public HomePageController() {
		System.out.println("in ctr of"+ getClass());
	}
	
	@RequestMapping("/")
	public ModelAndView showHomePage() {
		System.out.println("in home page");
		return new ModelAndView("/index","hello_time_is", LocalDateTime.now());
		
	}
	
	

}
