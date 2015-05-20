package com.training.bd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.models.User;


@Repository
public class UserDAOImpl implements UserDAO{
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	

	@Override
	@SuppressWarnings("unchecked")
	public User isUser(String username,String password) {		
		User flag = new User();
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where username = :un and password = :pass");
		query.setParameter("un", username);
		query.setParameter("pass", password);
		List<User> list = (List<User>) query.list();	
		
		if(list.size()>0){
			flag=list.get(0);
		}					
		return flag;		
	}
	

	@Override
	public User register(User user) {				
		Session session = this.sessionFactory.openSession();
	    session.saveOrUpdate(user);	  
	    session.flush();
	    session.close();
	    return user;
	}


	@Override
	@SuppressWarnings("unchecked")
	public boolean usernameExists(String username) {
		boolean flag = false;
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where username = :un");
		query.setParameter("un", username);		
		List<User> list = (List<User>) query.list();	
		if(list.size()>0)
			flag = true;
		return flag;
	}
	
}
