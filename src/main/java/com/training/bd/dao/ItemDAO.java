package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Item;
import com.training.bd.webModels.ItemDetails;

public interface ItemDAO {
	public ItemDetails getItemDetails(int itemID);
	public List<Item> getItemList();
	public void saveItem(Item item);
	public void updateItem(Item item);
	public void deleteItem(int itemID);

}
