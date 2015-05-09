package com.training.bd.models;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.bd.dao.UserDAO;

public class Tester {
	 public static void main(String[] args) {
		 
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	         
	        UserDAO UserDAO = context.getBean(UserDAO.class);
	         
	        User user = new User();
	        user.setUsername("don"); 
	        user.setPassword("haha");
	         
	        UserDAO.save(user);
	         
	        System.out.println("User::"+user.toString());
	         
	        
	        context.close();    
	    }
}
