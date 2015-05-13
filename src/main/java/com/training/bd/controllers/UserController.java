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





import com.training.bd.dao.UserDAO;
import com.training.bd.dao.UserDAO;
import com.training.bd.models.BidPlacement;
import com.training.bd.models.Item;
import com.training.bd.models.ItemDetails;
import com.training.bd.models.LoginObject;
import com.training.bd.models.Role;
import com.training.bd.models.User;
import com.training.bd.models.User;
import com.training.bd.models.UserFromWeb;

@Controller

public class UserController {
	ApplicationContext context ;
	UserDAO userDAO ;
	
	
	public UserController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		userDAO= (UserDAO) context.getBean("userDAO");
		
	}			
 

	@RequestMapping(value="/isUsernameExisting",method = RequestMethod.GET)
	public @ResponseBody boolean item(@RequestParam(value="username", required=true) String username){				
		return userDAO.usernameExists(username);		
	}
	
	@RequestMapping(value = "/login",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody User user(@RequestBody final UserFromWeb user){		
		return userDAO.isUser(user.getUsername(),user.getPassword());		
	}
	
	@RequestMapping(value = "/register",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody UserFromWeb reg(@RequestBody final UserFromWeb user){
		userDAO.register(user);	
		return user;
	}
		
}
