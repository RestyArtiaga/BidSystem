package com.training.bd.models;

public class Shop {
 
	String name;
	String staffName[];
 

	public void setName(String name) {
		this.name = name;
	}
	public void setStaffName(String[] staffName) {
		this.staffName = staffName;
	}
	public String getName() {
		return name;
	}
	public String[] getStaffName() {
		return staffName;
	}
 
}