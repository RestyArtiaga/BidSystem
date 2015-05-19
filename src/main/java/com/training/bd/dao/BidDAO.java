package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Bid;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemFromWeb;

public interface BidDAO {
	public List<Bid> getBidHistoryOf(int itemID);
	public double getHighestBid(int itemID);
	public void addBidHistory(Bid bid);
	public void updateCurrentPrice(Bid bid);
	public List<Integer> getAllBiddersOn(int itemID);
	public void deleteBidHistoryOn(int itemID);
}
