package com.training.bd.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.models.BidPlacement;
import com.training.bd.models.Item;
import com.training.bd.models.Item;
import com.training.bd.models.LoginObject;
import com.training.bd.models.Role;
import com.training.bd.models.User;
import com.training.bd.models.User;
import com.training.bd.models.UserFromWeb;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO{
	//@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
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
			flag=list.get(0);
		}					
		return flag;
	}
	

	@Override
	public void register(UserFromWeb user) {
		User userMain = new User();
		userMain.setUsername(user.getUsername());
		userMain.setPassword(user.getPassword());
		userMain.setRoles(new Role());
		userMain.getRole().setRoleID(user.getRoleID());
		Session session = this.sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(userMain);	       
	        tx.commit();
	        session.close();
	}


	@Override
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

	/*
	public void saveUser(User user) {		
		Session session = this.sessionFactory.openSession();
		 Transaction tx = session.beginTransaction();
	        session.saveOrUpdate(user);	       
	        tx.commit();
	        session.close();		
	}


	@Override
	public List<User> getUserList(){
		   Session session = this.sessionFactory.openSession(); 		   
		    List<User> list =(List<User>) session.createCriteria(User.class).list();  		   
		    session.close();
		    return list;  
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
			flag=list.get(0);
		}
			
		
		return flag;
	}



	public List<String> getRoles(int userID) {
		// TODO Auto-generated method stub
		return null;
	}
*/


	
}
