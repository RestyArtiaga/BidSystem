package com.training.bd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
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
		    List<User> list =(List<User>) session.createCriteria(User.class).list();  
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


	@Override
	public User isUser(String username,String password) {
		User flag = new User();
		Session session = this.sessionFactory.openSession();
		Query query = session.createQuery("from User where username = :un and password = :pass");
		query.setParameter("un", username);
		query.setParameter("pass", password);
		List<User> list = (List<User>) query.list();	
		if(list.size()>0){
			flag = list.get(0);
		}
		return flag;
	}


	@Override
	public List<String> getRoles(int userID) {
		// TODO Auto-generated method stub
		return null;
	}

}
