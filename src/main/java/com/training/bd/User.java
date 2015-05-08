package com.training.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="userID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;
	private String username;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public int getUserID() {
		return userID;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
