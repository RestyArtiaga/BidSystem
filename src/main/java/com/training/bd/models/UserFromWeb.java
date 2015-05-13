package com.training.bd.models;

public class UserFromWeb {
	private String username;
	private String password;
	private int roleID;
	
	public String getPassword() {
		return password;
	}public int getRoleID() {
		return roleID;
	}public String getUsername() {
		return username;
	}public void setPassword(String password) {
		this.password = password;
	}public void setRoleID(int roleID) {
		this.roleID = roleID;
	}public void setUsername(String username) {
		this.username = username;
	}
}
