package com.training.bd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.bd.dao.BidDAO;
import com.training.bd.dao.ItemDAO;
import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.ItemDetails;
import com.training.bd.webModels.ItemFromWeb;
import com.training.bd.webModels.StatusObject;

@Service
@Transactional
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemDAO itemDAOImpl;
	
	@Autowired
	BidDAO bidDAOImpl;
	
	@Override
	public ItemDetails getItemDetails(int itemID) {
		return itemDAOImpl.getItemDetails(itemID);
	}

	@Override
	public List<Item> getItemList() {
		return itemDAOImpl.getItemList();
	}

	@Override
	public Item saveItem(ItemFromWeb item) {
		Item itemMain = new Item();
		itemMain.setItemID(item.getItemID());
		itemMain.setDuration(item.getDuration());
		itemMain.setItemName(item.getItemName());
		itemMain.setItemDescription(item.getItemDescription());		
		itemMain.setCreatedAt(null);
		itemMain.setUser(new User());
		itemMain.getUser().setUserID(item.getUserID());
								
		itemDAOImpl.saveItem(itemMain);						    		    	   
		Bid bid = new Bid();		
		bid.setPrice(item.getPrice());
		bid.setUserID(new User());
		bid.getUserID().setUserID(item.getUserID());
		bid.setItem(itemMain);		
		bidDAOImpl.addBidHistory(bid);
		return itemMain;
	}

	@Override
	public StatusObject deleteItem(int itemID) {
		StatusObject obj = new StatusObject();
		itemDAOImpl.deleteItem(itemID);
		bidDAOImpl.deleteBidHistoryOn(itemID);
		obj.setStatus(true);
		return obj;
	}

	@Override
	public Item updateItem(ItemFromWeb item) {
		Item itemMain = new Item();
		itemMain.setItemID(item.getItemID());
		itemMain.setDuration(item.getDuration());
		itemMain.setItemName(item.getItemName());
		itemMain.setItemDescription(item.getItemDescription());		
		itemMain.setCreatedAt(null);
		itemMain.setUser(new User());
		itemMain.getUser().setUserID(item.getUserID());
		
		itemDAOImpl.updateItem(itemMain);
		
		Bid bid = new Bid();		
		bid.setPrice(item.getPrice());
		bid.setUserID(new User());
		bid.getUserID().setUserID(item.getUserID());
		bid.setItem(itemMain);
		
		List<Integer> bidders = bidDAOImpl.getAllBiddersOn(item.getItemID());
		if(bidders.size()>1){
			if(bidDAOImpl.getHighestBid(item.getItemID())<item.getPrice())
				bidDAOImpl.addBidHistory(bid);
		}else{
			bidDAOImpl.deleteBidHistoryOn(item.getItemID());
			bidDAOImpl.addBidHistory(bid);
		}
		return itemMain;
	}



	
	
}

