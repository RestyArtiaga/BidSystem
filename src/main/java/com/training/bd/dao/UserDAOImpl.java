package com.training.bd.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.training.bd.models.User;


@Repository
@Transactional
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
