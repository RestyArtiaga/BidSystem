package com.training.bd.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDAOImpl implements UserDAO{

	 private SessionFactory sessionFactory;
	 
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }
	    
	@Override
	public void save(User user) {
		Session session = this.sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
	        session.persist(user);
	        tx.commit();
	        session.close();
		
	}

}
