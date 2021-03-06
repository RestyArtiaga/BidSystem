package com.training.bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bd.models.User;
import com.training.bd.services.UserService;
import com.training.bd.webModels.StatusObject;
import com.training.bd.webModels.UserFromWeb;

@Controller
public class UserController {
	
	
	@Autowired
	UserService userService;
	
		
 
	
	@RequestMapping(value="/isUsernameExisting",method = RequestMethod.GET)
	public @ResponseBody StatusObject item(@RequestParam(value="username", required=true) String username){				
		return userService.usernameExists(username);
	}
	
	
	
	@RequestMapping(value = "/login",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody User login(@RequestBody final UserFromWeb user){		
		return userService.isUser(user.getUsername(),user.getPassword());
	}
	
	
	
	@RequestMapping(value = "/register",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody User reg(@RequestBody final UserFromWeb user){
		User use =  userService.register(user);
		System.out.println("blkjasdlkjsadf");
		return use;
	}
	
	
	
		
}
