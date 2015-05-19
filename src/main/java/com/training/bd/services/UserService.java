package com.training.bd.services;

import com.training.bd.models.User;
import com.training.bd.webModels.UserFromWeb;

public interface UserService {
	public User isUser(String username,String password);
	public User register(UserFromWeb user);
	public boolean usernameExists(String username);


}
