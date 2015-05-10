package com.training.bd.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.bd.JDBC.UserJDBCTemplate;
import com.training.bd.dao.UserDAO;
import com.training.bd.models.User;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	ApplicationContext context ;
	UserDAO userDAO ;
	UserJDBCTemplate userJDBCTemplate;
	
	public UserController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		userDAO= (UserDAO) context.getBean("userDAO");
		userJDBCTemplate = (UserJDBCTemplate)context.getBean("userJDBCTemplate");
	}
		
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public @ResponseBody User user(@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password){
		return userJDBCTemplate.isUser(username, password);		
	}

	
	@RequestMapping(value = "/role",  method = RequestMethod.GET)
	public @ResponseBody List<String> roles(@RequestParam(value="userid", required=true) int userID){
		return userJDBCTemplate.getRoles(userID);		
	}
}
