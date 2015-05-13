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



import com.training.bd.dao.ItemDAO;
import com.training.bd.dao.ItemDAO;
import com.training.bd.models.Item;
import com.training.bd.models.Item;
import com.training.bd.models.ItemDetails;
import com.training.bd.models.User;


@Controller
public class ItemController {
	ApplicationContext context ;
	ItemDAO itemDAO ;
	
		
	public ItemController() {
		context= new ClassPathXmlApplicationContext("spring.xml");
		itemDAO= (ItemDAO) context.getBean("itemDAO");
	}
	
	@RequestMapping(value="/getAllItems", method = RequestMethod.GET)
	public @ResponseBody List<Item> items(){		
		return itemDAO.getItemList();				
	}	
		
	@RequestMapping(value="/getItemDataOf",method = RequestMethod.GET)
	public @ResponseBody ItemDetails item(@RequestParam(value="itemID", required=true) int itemID){
		ItemDetails iDetails = new ItemDetails();
		iDetails = itemDAO.getItemDetails(itemID);
		
		return iDetails;
		//return null;
	}
}