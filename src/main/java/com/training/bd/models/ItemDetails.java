package com.training.bd.models;

public class ItemDetails {
	private Item item;
	private BidHistory highestBid;
	public void setHighestBid(BidHistory highestBid) {
		this.highestBid = highestBid;
	}public void setItem(Item item) {
		this.item = item;
	}public BidHistory getHighestBid() {
		return highestBid;
	}public Item getItem() {
		return item;
	}
	
}
