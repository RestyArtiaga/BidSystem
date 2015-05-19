package com.training.bd.services;

import java.util.List;

import com.training.bd.models.Bid;
import com.training.bd.webModels.BidFromWeb;

public interface BidService {
	public boolean placeBid(BidFromWeb bidPlacement);
	public List<Bid> getBidHistoryOf(int itemID);
}
