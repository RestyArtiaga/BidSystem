package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Bid;

public interface BidDAO {
	public List<Bid> getBidHistoryOf(int itemID);
	public double getHighestBid(int itemID);
	public Bid getHighestBidOf(int itemID);
	public void addBidHistory(Bid bid);
	public void updateCurrentPrice(Bid bid);
	public List<Integer> getAllBiddersOn(int itemID);
	public void deleteBidHistoryOn(int itemID);
}
