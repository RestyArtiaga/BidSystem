package com.training.bd.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.bd.models.User;

public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setUserID(rs.getInt("userID"));
      user.setUsername(rs.getString("username"));
      user.setPassword(rs.getString("password"));      
      return user;
   }
}