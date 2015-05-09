package com.training.bd.models;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bd.dao.*;

public class Tester {
	 public static void main(String[] args) {
		 
	        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	         
	        UserDAO UserDAO = (UserDAO) context.getBean("userDAO");
	         
	        User user = new User();
	        user.setUsername("don"); 
	        user.setPassword("haha");
	         
	        UserDAO.save(user);
	         
	        System.out.println("User::"+user.toString());
	         
	        
	            
	    }
}
