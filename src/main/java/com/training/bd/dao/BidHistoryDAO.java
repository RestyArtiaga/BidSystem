package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.BidHistory;
import com.training.bd.webModels.BidFromWeb;
import com.training.bd.webModels.ItemFromWeb;

public interface BidHistoryDAO {
	public boolean placeBid(BidFromWeb bidPlacement);
	public List<BidHistory> getBidHistoryOf(int itemID);

}
