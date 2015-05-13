package com.training.bd.webModels;

public class BidFromWeb {
	private int itemID;
	private int userID;
	private double price;
	
	public int getItemID() {
		return itemID;
	}public double getPrice() {
		return price;
	}public int getUserID() {
		return userID;
	}public void setItemID(int itemID) {
		this.itemID = itemID;
	}public void setPrice(double price) {
		this.price = price;
	}public void setUserID(int userID) {
		this.userID = userID;
	}
}
