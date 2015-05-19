package com.training.bd.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.dao.BidDAO;
import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.StatusObject;

@Repository
public class BidServiceImpl implements BidService {
	
	@Autowired
	BidDAO bidDAOImpl;
	
	@Override
	public StatusObject placeBid(BidFromWeb bidPlacement) {
		StatusObject flag = new StatusObject();
		if(bidDAOImpl.getHighestBid(bidPlacement.getItemID())<bidPlacement.getPrice()){
			Bid bh = new Bid();
			Item item = new Item();
			item.setItemID(bidPlacement.getItemID());
			User user = new User();
			user.setUserID(bidPlacement.getUserID());
			bh.setItem(item);
			bh.setUserID(user);
			bh.setPrice(bidPlacement.getPrice());
			bidDAOImpl.addBidHistory(bh);
			flag.setStatus(true);
		}else
			flag.setStatus(false);
				
		return flag;
	}
	
	@Override
	public List<Bid> getBidHistoryOf(int itemID) {
		return bidDAOImpl.getBidHistoryOf(itemID);
	}	

}
