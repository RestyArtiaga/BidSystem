package com.training.bd.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;

@Entity
@Table(name="item")
public class Item {

	@Id
	@Column(name="itemID")
	private int itemID;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userID")
	@JsonManagedReference
	private User user;	
	
	@Column(name="itemName")
	private String itemName;
	
	@Column(name="itemDescription")
	private String itemDescription;
	
	@Column(name="duration")
	private int duration;
	
	@Column(name="createdAt")
	private transient Date createdAt;
	

	@OneToMany(mappedBy="bidID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)		
	@JsonIgnore
	private List<BidHistory> bids;
	
	public List<BidHistory> getBids() {
		return bids;
	}public void setBids(List<BidHistory> bids) {
		this.bids = bids;
	}
	public Date getCreatedAt() {
		return createdAt;
	}public int getDuration() {
		return duration;
	}public String getItemDescription() {
		return itemDescription;
	}public int getItemID() {
		return itemID;
	}public String getItemName() {
		return itemName;
	}public User getUser() {
		return user;
	}public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}public void setDuration(int duration) {
		this.duration = duration;
	}public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}public void setItemID(int itemID) {
		this.itemID = itemID;
	}public void setItemName(String itemName) {
		this.itemName = itemName;
	}public void setUser(User user) {
		this.user = user;
	}
}
