package com.training.bd.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.dao.BidDAO;
import com.training.bd.dao.ItemDAO;
import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.StatusObject;

@Repository
public class BidServiceImpl implements BidService {
	public static final long HOUR = 3600*1000;
	
	@Autowired
	BidDAO bidDAOImpl;
	
	@Autowired
	ItemDAO itemDAOImpl;
	
	@Override
	public StatusObject placeBid(BidFromWeb bidPlacement) {
		StatusObject flag = new StatusObject();
		Item item = itemDAOImpl.getItem(bidPlacement.getItemID());
		Date endDate,date;
		try {
						
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
			date = format.parse(item.getCreatedAt());
			endDate = new Date(date.getTime() + (item.getDuration() * HOUR));
			
			System.out.println("created at: " + date);
			System.out.println("end date: " + endDate);			
			System.out.println("current date: " + new Date());
			System.out.println(endDate.after(new Date()));

			if(endDate.before(new Date())){
				if(bidDAOImpl.getHighestBid(bidPlacement.getItemID())<bidPlacement.getPrice()){
					Bid bh = new Bid();						
					User user = new User();
					user.setUserID(bidPlacement.getUserID());
					bh.setItem(item);
					bh.setUserID(user);
					bh.setPrice(bidPlacement.getPrice());
					bidDAOImpl.addBidHistory(bh);
					flag.setStatus(true);
				}else
					flag.setStatus(false);
			}else
				flag.setStatus(false);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return flag;
	}
	
		
	
	@Override
	public List<Bid> getBidHistoryOf(int itemID) {
		return bidDAOImpl.getBidHistoryOf(itemID);
	}	

}
