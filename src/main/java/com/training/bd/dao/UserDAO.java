package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.User;

public interface UserDAO {
	public void saveUser(User user);
	public List<User> getUserList();
	public User isUser(String username,String password);
	
}
