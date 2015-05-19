package com.training.bd.services;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.bd.dao.BidDAO;
import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemFromWeb;

@Repository
public class BidServiceImpl implements BidService {
	
	@Autowired
	BidDAO bidDAOImpl;
	
	@Override
	public boolean placeBid(BidFromWeb bidPlacement) {
		boolean flag = false;
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
			flag = true;
		}
				
		return flag;
	}
	
	@Override
	public List<Bid> getBidHistoryOf(int itemID) {
		return bidDAOImpl.getBidHistoryOf(itemID);
	}	

}
