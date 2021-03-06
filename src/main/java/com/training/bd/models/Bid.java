package com.training.bd.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="bidHistory")
@DynamicUpdate
@DynamicInsert
public class Bid {
	
	
	@Id
	@Column(name="bidID")
	private int bidID;			
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userID")
	@JsonManagedReference
	private User userID;	
	
			
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "itemID")	
	private Item item;	

	
	@Column(name="price")
	private double price;
		
	@Column(name="createdAt")
	private  String createdAt;
	
	public String getCreatedAt() {
		return createdAt;
	}public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public Item getItem() {
		return item;
	}public void setItem(Item item) {
		this.item = item;
	}
	
	public void setBidID(int bidID) {
		this.bidID = bidID;
	}public void setPrice(double price) {
		this.price = price;
	}public void setUserID(User userID) {
		this.userID = userID;
	}public int getBidID() {
		return bidID;
	}public double getPrice() {
		return price;
	}public User getUserID() {
		return userID;
	}	 
}
