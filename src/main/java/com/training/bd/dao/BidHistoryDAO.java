package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.BidHistory;
import com.training.bd.models.BidPlacement;
import com.training.bd.models.ItemFromWeb;

public interface BidHistoryDAO {
	public boolean placeBid(BidPlacement bidPlacement);
	public List<BidHistory> getBidHistoryOf(int itemID);
/*	public void addBidHistory(BidHistory bidHistory);
	public boolean placeBid(BidPlacement bidPlacement);
	public void setStartingPrice(ItemFromWeb item);*/
}
