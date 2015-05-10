package com.training.bd.JDBC;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.training.bd.dao.UserDAO;
import com.training.bd.models.BidPlacement;
import com.training.bd.models.User;

public class UserJDBCTemplate implements UserDAO {
	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User isUser(String username, String password) {
		 String SQL = "select * from user where username = ? and password = ?";
	     User user = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{username,password}, new UserMapper());
	     
	     if(user!=null)
	    	 user.setRole(getRoles(user.getUserID()));
	     else 
	    	 return new User();
	     return user;		
	}

	private List<String> getRoles(int userID) {
		 String SQL = "select role from roles r,userrole ur where ur.userID = ? and r.roleID = ur.roleID";
		 List<String> roles = jdbcTemplateObject.queryForList(SQL,new Object[]{userID},String.class);	   
	     return roles;		
	}
	
	@Override
	public boolean placeBid(BidPlacement bid) {
		// TODO Auto-generated method stub
		return false;
	}

}
