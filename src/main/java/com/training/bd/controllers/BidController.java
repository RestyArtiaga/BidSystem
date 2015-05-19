package com.training.bd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.training.bd.dao.BidDAO;
import com.training.bd.dao.BidDAOImpl;
import com.training.bd.dao.ItemDAO;
import com.training.bd.services.BidService;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemFromWeb;

@Controller
public class BidController {
	
	@Autowired
	BidService bidServiceImpl;
	

	@RequestMapping(value="/placeBid",consumes="application/json", method = RequestMethod.POST)
	public @ResponseBody boolean placeBid(@RequestBody BidFromWeb bid){		
		return bidServiceImpl.placeBid(bid);
	}
	
}
