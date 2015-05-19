package com.training.bd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.models.Bid;
import com.training.bd.models.Item;
import com.training.bd.webModels.ItemDetails;

@Repository
public class ItemDAOImpl implements ItemDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

	
	@Override
	@SuppressWarnings("unchecked")
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
	

	@SuppressWarnings("unchecked")
	public Bid getHighestBid(int itemID){
		Bid flag = new Bid();
		
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + Bid.class.getName() +" where itemID = :id order by price desc ");		
		query.setParameter("id", itemID);
		query.setMaxResults(1);
		List<Bid> list = (List<Bid>) query.list();	
		session.close();
		
		if(list.size()>0){
			flag=list.get(0);
		}
		return flag; 		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Item> getItemList() {	
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + Item.class.getName());				
		List<Item> list = (List<Item>) query.list();		
		session.close();	
		return list;
	}

	@Override
	public void saveItem(Item item) {				
		Session session = this.sessionFactory.openSession();			
		session.save(item);	    			    
	    session.close();	    
	}
	
	
	

	@Override
	public void deleteItem(int itemID) {
		Session session = this.sessionFactory.openSession();
		Item item = new Item();
		item.setItemID(itemID);
		session.delete(item);
		session.flush();
				
		Query query = session.createQuery("delete "+  Bid.class.getName() +" where itemID = :id");
		query.setParameter("id",itemID);		 
		int result = query.executeUpdate();
		System.out.println(result);				
	}

	
	@Override
	public void updateItem(Item item) {
		Session session = this.sessionFactory.openSession();
		session.update(item);
		session.flush();
	    session.close();		
	}
				
}

