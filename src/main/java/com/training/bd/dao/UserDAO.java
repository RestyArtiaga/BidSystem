package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.BidPlacement;
import com.training.bd.models.LoginObject;
import com.training.bd.models.User;
import com.training.bd.models.User;
import com.training.bd.models.UserFromWeb;

public interface UserDAO {
	public User isUser(String username,String password);
	public void register(UserFromWeb user);
	/*public void saveUser(User user);
	public List<User> getUserList();
	public User isUser(String username,String password);*/

}
