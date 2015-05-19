package com.training.bd.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.bd.dao.UserDAO;
import com.training.bd.models.Role;
import com.training.bd.models.User;
import com.training.bd.webModels.UserFromWeb;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired	
	public UserDAO userDAOImpl;
			
	public void setUserDAO(UserDAO userDAOImpl) {
		this.userDAOImpl = userDAOImpl;
	}
		
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
	public boolean usernameExists(String username) {
		return userDAOImpl.usernameExists(username);
	}
	
}
