package com.training.bd.services;

import java.util.List;

import com.training.bd.models.Bid;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.StatusObject;

public interface BidService {
	public StatusObject placeBid(BidFromWeb bidPlacement);
	public List<Bid> getBidHistoryOf(int itemID);
}
