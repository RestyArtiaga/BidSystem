package com.training.bd.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.training.bd.models.Item;
import com.training.bd.models.User;

public class ItemDAOImpl implements ItemDAO{

	//@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    session.saveOrUpdate(item);
	    tx.commit();
	    session.close();		
	}

	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
