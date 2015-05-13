package com.training.bd.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import org.springframework.beans.factory.annotation.Autowired;

import com.training.bd.models.BidHistory;
import com.training.bd.models.Item;
import com.training.bd.models.Item;
import com.training.bd.models.ItemDetails;
import com.training.bd.models.Role;
import com.training.bd.models.User;
import com.training.bd.models.User;
import com.training.bd.webModels.ItemFromWeb;

public class ItemDAOImpl implements ItemDAO{

	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public ItemDetails getItemDetails(int itemID) {
		ItemDetails flag = new ItemDetails();
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + Item.class.getName() +" where itemID = :id");		
		query.setParameter("id", itemID);		
		List<Item> list = (List<Item>) query.list();		
		session.close();
	
		if(list.size()>0){
			flag.setItem(list.get(0));
		}
		
		flag.setHighestBid(getHighestBid(itemID));
					
		return flag;
	}
	
	public BidHistory getHighestBid(int itemID){
		BidHistory flag = new BidHistory();
		
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + BidHistory.class.getName() +" where itemID = :id order by price desc ");		
		query.setParameter("id", itemID);
		query.setMaxResults(1);
		List<BidHistory> list = (List<BidHistory>) query.list();	
		session.close();
		
		if(list.size()>0){
			flag=list.get(0);
		}
		return flag; 		
	}

	@Override
	public List<Item> getItemList() {	
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + Item.class.getName());				
		List<Item> list = (List<Item>) query.list();		
		session.close();
	
		return list;
	}

	@Override
	public void saveItem(ItemFromWeb item) {
		Item itemMain = new Item();
		itemMain.setDuration(item.getDuration());
		itemMain.setItemName(item.getItemName());
		itemMain.setItemDescription(item.getItemDescription());		
		itemMain.setUser(new User());
		itemMain.getUser().setUserID(item.getUserID());
		BidHistory bid = new BidHistory();
		
		bid.setPrice(item.getPrice());
		bid.setUserID(new User());
		bid.getUserID().setUserID(item.getUserID());
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();		
		session.save(itemMain);	    
	    tx.commit();	    	   	    
	    tx = session.beginTransaction();
	    bid.setItem(itemMain);
	    session.save(bid);
	    tx.commit();	
	    session.close();
	    //System.out.println(itemMain.getItemID());
	}


	
	
}

