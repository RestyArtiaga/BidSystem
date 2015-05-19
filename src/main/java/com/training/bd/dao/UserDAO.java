package com.training.bd.dao;

import java.util.List;



import com.training.bd.models.User;
import com.training.bd.models.User;
import com.training.bd.webModels.LoginObject;
import com.training.bd.webModels.UserFromWeb;

public interface UserDAO {
	public User isUser(String username,String password);
	public User register(User user);
	public boolean usernameExists(String username);


}
