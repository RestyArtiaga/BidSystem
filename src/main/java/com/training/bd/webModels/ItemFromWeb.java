package com.training.bd.webModels;

public class ItemFromWeb {
	private int itemID;
	private int userID;	
	private String itemName;
	private String itemDescription;
	private int duration;
	private double price;
	
	public int getItemID() {
		return itemID;
	}public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}public void setItemName(String itemName) {
		this.itemName = itemName;
	}public void setPrice(double price) {
		this.price = price;
	}public void setUserID(int userID) {
		this.userID = userID;
	}public int getDuration() {
		return duration;
	}public String getItemDescription() {
		return itemDescription;
	}public String getItemName() {
		return itemName;
	}public double getPrice() {
		return price;
	}public int getUserID() {
		return userID;
	}
}
