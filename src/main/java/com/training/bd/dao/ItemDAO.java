package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Item;

public interface ItemDAO {
	public void saveItem(Item item);
	public List<Item> getItemList();
}
