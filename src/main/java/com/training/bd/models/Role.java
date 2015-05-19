package com.training.bd.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@Column(name="roleID")
	@JoinColumn(name = "roleID")
	private int roleID;

	@Column(name="role")
	private String role;
	
	@OneToMany(mappedBy="userID", fetch = FetchType.EAGER, cascade = CascadeType.ALL)		 
	@JsonBackReference
	private List<User> user;
	
	
	public List<User> getUser() {
		return user;
	}public void setUser(List<User> user) {
		this.user = user;
	}

	public String getRole() {
		return role;	
	}public void setRoleID(int roleID) {
		this.roleID = roleID;
	}public void setRole(String role) {
		this.role = role;
	}public int getRoleID() {
		return roleID;
	}
}
