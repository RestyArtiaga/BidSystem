package com.training.bd.dao;

import com.training.bd.models.User;

public interface UserDAO {
	public User isUser(String username,String password);
	public User register(User user);
	public boolean usernameExists(String username);


}
