package com.training.bd.dao;

import java.util.List;

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
	public List<User> getUserList(){
		   Session session = this.sessionFactory.openSession(); 
		   Transaction tx = session.beginTransaction();
		    List<User> list = session.createCriteria(User.class).list();  
		    tx.commit();
		    session.close();
		    return list;  
	}

	@Override
	public void saveUser(User user) {
		Session session = this.sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(user);
	        tx.commit();
	        session.close();
		
	}

}
