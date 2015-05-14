package com.training.bd.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.bd.models.BidHistory;
import com.training.bd.models.Item;
import com.training.bd.models.User;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemFromWeb;

@Repository
@Transactional
public class BidHistoryDAOImpl implements BidHistoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }	
	
	private void addBidHistory(BidHistory bidHistory) {				
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
	    session.saveOrUpdate(bidHistory);
	    tx.commit();
	    session.close();
	}
	@Override
	public boolean placeBid(BidFromWeb bidPlacement) {
		boolean flag = false;
		if(bidPlacement.getPrice() > getHighestBid(bidPlacement.getItemID())){
			BidHistory bh = new BidHistory();
			Item item = new Item();
			item.setItemID(bidPlacement.getItemID());
			User user = new User();
			user.setUserID(bidPlacement.getUserID());
			bh.setItem(item);
			bh.setUserID(user);
			bh.setPrice(bidPlacement.getPrice());
			addBidHistory(bh);
			flag = true;
		}
		
		return flag;
	}
	private double getHighestBid(int itemID){
		double flag = 0;		
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hqlUpdate = "select max(price) from " + BidHistory.class.getName() + " where itemID = :itemID";
		Query query = session.createQuery( hqlUpdate )
		        .setInteger( "itemID", itemID);
		List<Double> resultSet = (List<Double>) query.list();
		tx.commit();
		session.close();
		if(resultSet.size()>=1)
			flag = resultSet.get(0);
		
		return flag; 		
	}

	@Override
	public List<BidHistory> getBidHistoryOf(int itemID) {
		 Session session = this.sessionFactory.openSession(); 		   
		    List<BidHistory> list =(List<BidHistory>) session.createCriteria(BidHistory.class).list();  		   
		    session.close();
		    return list; 
	}
	

}
