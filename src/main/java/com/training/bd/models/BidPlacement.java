package com.training.bd.models;


public class BidPlacement {
	private int itemID;
	private int bidderID;
	private double price;
	
	public int getBidderID() {
		return bidderID;
	}public int getItemID() {
		return itemID;
	}public double getPrice() {
		return price;
	}public void setBidderID(int bidderID) {
		this.bidderID = bidderID;
	}public void setItemID(int itemID) {
		this.itemID = itemID;
	}public void setPrice(double price) {
		this.price = price;
	}public BidPlacement() {
		// TODO Auto-generated constructor stub
	}
	
}
