package com.training.bd.controllers;

import java.util.ArrayList;
import java.util.List;

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



import com.training.bd.dao.BidHistoryDAO;
import com.training.bd.dao.ItemDAO;
import com.training.bd.dao.ItemDAO;
import com.training.bd.dao.UserDAO;
import com.training.bd.models.Item;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.ItemFromWeb;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	ApplicationContext context ;
	ItemDAO itemDAO ;
	BidHistoryDAO bhDAO;	
	
	public AdminController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		itemDAO= (ItemDAO) context.getBean("itemDAO");
		bhDAO= (BidHistoryDAO) context.getBean("bidHistoryDAO");
	}				

}