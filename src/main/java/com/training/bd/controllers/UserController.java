package com.training.bd.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.bd.JDBC.UserJDBCTemplate;
import com.training.bd.dao.UserDAO;
import com.training.bd.models.BidPlacement;
import com.training.bd.models.Item;
import com.training.bd.models.User;

@Controller

public class UserController {
	ApplicationContext context ;
	UserDAO userDAO ;
	UserJDBCTemplate userJDBCTemplate;
	
	public UserController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		userDAO= (UserDAO) context.getBean("userDAO");
		userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	}
		
	
 
	@RequestMapping(value = "/login", consumes="application/json",  method = RequestMethod.POST)
	public @ResponseBody User user(@RequestBody final User user){
		//return user;
		return userJDBCTemplate.isUser(user.getUsername(), user.getPassword());		
	}
	
	@RequestMapping(value="/user/placeBid",consumes="application/json", method=RequestMethod.POST)
	public @ResponseBody boolean item(@RequestBody final BidPlacement bidPlacement){
		//return bidPlacement;
		return userDAO.placeBid(bidPlacement);						
	}
}
