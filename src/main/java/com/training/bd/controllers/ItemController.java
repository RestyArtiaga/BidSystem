package com.training.bd.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bd.models.Item;
import com.training.bd.services.ItemService;
import com.training.bd.webModels.ItemDetails;
import com.training.bd.webModels.ItemFromWeb;
import com.training.bd.webModels.StatusObject;


@Controller
public class ItemController {
	
	@Autowired
	ItemService itemServiceImpl;
	
	
	@RequestMapping(value="/getAllItems", method = RequestMethod.GET)
	public @ResponseBody List<Item> items(){		
		return itemServiceImpl.getItemList();				
	}
	
	@RequestMapping(value="/getItemDataOf",method = RequestMethod.GET)
	public @ResponseBody ItemDetails item(@RequestParam(value="itemID", required=true) int itemID){
		ItemDetails iDetails = new ItemDetails();
		iDetails = itemServiceImpl.getItemDetails(itemID);		
		return iDetails;
	}
	
	@RequestMapping(value="/addItem",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody Item item(@RequestBody ItemFromWeb item){
		return itemServiceImpl.saveItem(item);				
	}
	
	@RequestMapping(value="/deleteItem",method = RequestMethod.DELETE)
	public @ResponseBody StatusObject itemDelete(@RequestParam(value="itemID", required=true) int itemID){
		return itemServiceImpl.deleteItem(itemID);
	}
	
	@RequestMapping(value="/updateItem",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody Item update(@RequestBody ItemFromWeb item){
		return itemServiceImpl.updateItem(item);		
	}
}