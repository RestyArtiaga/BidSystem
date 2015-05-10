package com.training.bd.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.bd.models.Item;

public class ItemMapper implements RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet rs, int arg1) throws SQLException {
		Item item = new Item();
		item.setItemID(rs.getInt("itemID"));
		item.setUserID(rs.getInt("userID"));
		item.setItemName(rs.getString("itemName"));
		item.setItemDescription(rs.getString("description"));
		item.setDuration(rs.getInt("duration"));
		item.setHighestBidderID(rs.getInt("highestBidderID"));
		item.setCurrentPrice(rs.getDouble("currentPrice"));
		return item;
	}

}
