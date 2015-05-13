package com.training.bd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewController {
	
	@RequestMapping(value = "/formLogin",  method = RequestMethod.GET)
	public ModelAndView loginPage() {
		 
		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Custom Login Form");
		//model.addObject("message", "This is protected page!");
		model.setViewName("login");
 
		return model; 
	}	
	
	@RequestMapping(value = "/admin",  method = RequestMethod.GET)
	public ModelAndView adminPage() {
		 
		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Custom Login Form");
		//model.addObject("message", "This is protected page!");
		model.setViewName("admin");
 
		return model; 
	}	
	
	@RequestMapping(value = "/formRegister",  method = RequestMethod.GET)
	public ModelAndView registerPage() {
		 
		ModelAndView model = new ModelAndView();
		//model.addObject("title", "Spring Security Custom Login Form");
		//model.addObject("message", "This is protected page!");
		model.setViewName("register");
 
		return model; 
	}
	
}
