package com.training.bd.dao;

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
import com.training.bd.models.ItemFromWeb;
import com.training.bd.models.User;
import com.training.bd.models.User;

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
		Query query = session.createQuery("from " + Item.class.getName() +" it inner join " + BidHistory.class.getName()
					+ " bh on it.itemID = bh.itemID ");				
		List<Item> list = (List<Item>) query.list();	
		session.close();							
		return list;
	}


	
	
}
