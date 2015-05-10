package com.training.bd.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bd.JDBC.ItemJDBCTemplate;

import com.training.bd.dao.ItemDAO;
import com.training.bd.models.Item;
import com.training.bd.models.User;


@Controller
public class ItemController {
	ApplicationContext context ;
	ItemDAO itemDAO ;
	ItemJDBCTemplate itemJDBCTemplate;
		
	public ItemController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		itemDAO= (ItemDAO) context.getBean("itemDAO");
		itemJDBCTemplate = (ItemJDBCTemplate)context.getBean("itemJDBCTemplate");
	}
		
	
	@RequestMapping(value="/getAllItems", method = RequestMethod.GET)
	public @ResponseBody List<Item> items(){
		List<Item> flag = new ArrayList();
		flag = itemJDBCTemplate.getItemList();		
		return flag;
	}	
		
	
	
	
}