package com.training.bd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.training.bd.models.Bid;

@Repository
public class BidDAOImpl implements BidDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void addBidHistory(Bid bidHistory) {				
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    session.saveOrUpdate(bidHistory);
	    tx.commit();
	    session.close();
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public double getHighestBid(int itemID){
		double flag = 0;		
		Session session = this.sessionFactory.openSession();
		String hqlUpdate = "select max(price) from " + Bid.class.getName() + " where itemID = :itemID";
		Query query = session.createQuery( hqlUpdate ).setInteger( "itemID", itemID);
		List<Double> resultSet = (List<Double>) query.list();		
		session.close();
		if(resultSet.size()>=1)
			flag = resultSet.get(0);
		
		return flag; 		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bid> getBidHistoryOf(int itemID) {
		 Session session = this.sessionFactory.openSession(); 		   
		 List<Bid> list =(List<Bid>) session.createCriteria(Bid.class).list();  		   
		 session.close();
		 return list; 
	}
	
	@Override
	public void updateCurrentPrice(Bid bid){
		Session session = this.sessionFactory.openSession(); 		   
		session.update(bid);  		   
		session.close();		
	}


	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getAllBiddersOn(int itemID) {
			
		Session session = this.sessionFactory.openSession();
		String hqlUpdate = "select distinct(userID) from " + Bid.class.getName() + " where itemID = :itemID";
		Query query = session.createQuery( hqlUpdate ).setInteger( "itemID", itemID);
		List<Integer> resultSet = (List<Integer>) query.list();		
		session.close();
		
		return resultSet; 	
	}


	@Override
	public void deleteBidHistoryOn(int itemID) {		
		Session session = this.sessionFactory.openSession();
		String hqlUpdate = "delete from " + Bid.class.getName() + " where itemID = :itemID";
		Query query = session.createQuery( hqlUpdate ).setInteger( "itemID", itemID);
		query.executeUpdate();		
		session.close();				
	}

}
