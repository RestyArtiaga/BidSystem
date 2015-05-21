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
	public Item getItem(int itemID) {
		Item flag = new Item();
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from " + Item.class.getName() +" where itemID = :id");		
		query.setParameter("id", itemID);
		@SuppressWarnings("unchecked")
		List<Item> list = (List<Item>) query.list();		
		session.close();
	
		if(list.size()>0){
			flag = list.get(0);
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
	public Item saveItem(Item item) {				
		Session session = this.sessionFactory.openSession();			
		session.save(item);	    			    
	    session.close();
	    return item;
	}
		
	@Override
	public void deleteItem(int itemID) {
		Session session = this.sessionFactory.openSession();
		Item item = new Item();
		item.setItemID(itemID);
		session.delete(item);
		session.flush();			 
	}

	
	@Override
	public Item updateItem(Item item) {
		Session session = this.sessionFactory.openSession();
		session.update(item);
		session.flush();
	    session.close();
	    return item;
	}
				
}

