package com.training.bd.models;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.training.bd.dao.*;
import com.training.*;

public class Tester {
    
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		/*UserDAO UserDAO = (UserDAO) context.getBean("userDAO");
		System.out.println("ID = " + UserDAO.isUser("Pankaj").toString());*/
		//user tests 
//		UserDAO UserDAO = (UserDAO) context.getBean("userDAO");
//		 
//		User user = new User();
//		user.setUserID(6);
//		user.setUsername("ye"); 
//		user.setPassword("password");
//		UserDAO.saveUser(user);
//		 
//		for(User el : UserDAO.getUserList() ) {
//			System.out.println( el.toString() );
//		}
		
		//item tests
		//ApplicationContext ctx = new AnnotationConfigApplicationContext("spring.xml");
	/*	
		ItemDAO itemDAO = (ItemDAO) context.getBean("itemDAO");
		 
		Item i = new Item();
		
		i.setItemName("selpon"); 
		i.setUserID(1);
		i.setDuration(2);
		i.setCurrentPrice(10.1);
		i.setHighestBidder(1);
		i.setItemDescription("wooooow");
		 
		itemDAO.saveItem(i);*/
//		for(User el : UserDAO.getUserList() ) {
//			System.out.println( el.toString() );
//		}
		
	}
	
}
