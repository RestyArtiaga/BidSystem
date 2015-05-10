package com.training.bd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Item")
public class Item{
	
	@Id
	@Column(name="itemID")	
	private int itemID;

	@Column(name="itemName")
	private String itemName;
	
	@Column(name="userID")
	private int userID;
	
	@Column(name="description")
	private String itemDescription;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="currentPrice")
	private double currentPrice;
	
	@Column(name="highestBidderID")
	private int HighestBidderID;
	
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getDuration() {
		return duration;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getHighestBidderID() {
		return HighestBidderID;
	}
	public void setHighestBidderID(int highestBidderID) {
		HighestBidderID = highestBidderID;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	public int getHighestBidder() {
		return HighestBidderID;
	}
	public void setHighestBidder(int highestBidder) {
		HighestBidderID = highestBidder;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String toString() {
		return 	"\nItem Name: " + itemName +
				"\nOwner: " + userID +
				"\nItem Description: " + itemDescription +
				"\nBid Duration" + duration +
				"\nCurrent Bid : " + currentPrice +
				"\nHighest Bidder" + HighestBidderID;
	}

}
