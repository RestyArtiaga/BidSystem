package com.training.bd.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.bd.dao.UserDAO;
import com.training.bd.models.Role;
import com.training.bd.models.User;
import com.training.bd.webModels.StatusObject;
import com.training.bd.webModels.UserFromWeb;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired	
	public UserDAO userDAOImpl;
			

	@Override
	public User isUser(String username,String password) {			
		return userDAOImpl.isUser(username, password);
	}
	
	@Override
	public User register(UserFromWeb user) {
		User userMain = new User();
		userMain.setUsername(user.getUsername());
		userMain.setPassword(user.getPassword());
		userMain.setRoles(new Role());
		userMain.getRole().setRoleID(user.getRoleID());
				
		return userDAOImpl.register(userMain);
	}


	@Override
	public StatusObject usernameExists(String username) {
		StatusObject flag = new StatusObject();
		flag.setStatus(userDAOImpl.usernameExists(username));
		return flag;
	}
	
}
