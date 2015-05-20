package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Item;
import com.training.bd.webModels.ItemDetails;

public interface ItemDAO {
	public ItemDetails getItemDetails(int itemID);
	public List<Item> getItemList();
	public Item saveItem(Item item);
	public Item updateItem(Item item);
	public void deleteItem(int itemID);

}
