package com.training.bd.JDBC;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.training.bd.dao.ItemDAO;
import com.training.bd.models.Item;

public class ItemJDBCTemplate implements ItemDAO{

	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
	@Override
	public void saveItem(Item item) {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public List<Item> getItemList() {
		 String SQL = "select * from item";
		 List<Item> items =jdbcTemplateObject.query(SQL,new ItemMapper());	   
	     return items;	
	}

}
