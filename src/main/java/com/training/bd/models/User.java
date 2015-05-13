package com.training.bd.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;



@Entity
@Table(name="user")
public class User {
	
	
	@Id
	@Column(name="userID")
	private int userID;

	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleID")
	@JsonManagedReference
	private Role role;	
	

	@OneToMany(mappedBy="itemID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)		 
	@JsonBackReference
	private List<Item> items;
	
	
	public List<Item> getItems() {
		return items;
	}public void setItems(List<Item> items) {
		this.items = items;
	}	
	public void setPassword(String password) {
		this.password = password;
	}public void setRoles(Role role) {
		this.role= role;
	}public void setUserID(int userID) {
		this.userID = userID;
	}public void setUsername(String username) {
		this.username = username;
	}public String getPassword() {
		return password;
	}public Role getRole() {
		return role;
	}public int getUserID() {
		return userID;
	}public String getUsername() {
		return username;
	}
}
