package com.training.bd.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bd.JDBC.UserJDBCTemplate;
import com.training.bd.dao.ItemDAO;
import com.training.bd.dao.UserDAO;
import com.training.bd.models.Item;
import com.training.bd.models.User;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	ApplicationContext context ;
	ItemDAO itemDAO ;
	
	
	public AdminController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		itemDAO= (ItemDAO) context.getBean("itemDAO");
		
	}
		
	@RequestMapping(value="addItem",consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public @ResponseBody Item item(@ModelAttribute Item item){
		//itemDAO.saveItem(item);
		return item;
	}
	
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public @ResponseBody User user(@RequestParam(value="username", required=true) String username,
			@RequestParam(value="password", required=true) String password){
		return null;		
	}
	
}