package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Item;
import com.training.bd.webModels.ItemDetails;

public interface ItemDAO {	
	public List<Item> getItemList();
	public Item saveItem(Item item);
	public Item getItem(int itemID);
	public Item updateItem(Item item);
	public void deleteItem(int itemID);

}
