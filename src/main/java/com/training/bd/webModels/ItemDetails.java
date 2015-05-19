package com.training.bd.webModels;

import com.training.bd.models.Bid;
import com.training.bd.models.Item;

public class ItemDetails {
	private Item item;
	private Bid highestBid;
	public void setHighestBid(Bid highestBid) {
		this.highestBid = highestBid;
	}public void setItem(Item item) {
		this.item = item;
	}public Bid getHighestBid() {
		return highestBid;
	}public Item getItem() {
		return item;
	}
	
}
