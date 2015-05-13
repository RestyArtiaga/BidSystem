package com.training.bd.dao;

import java.util.List;

import com.training.bd.models.Item;
import com.training.bd.models.Item;
import com.training.bd.models.ItemDetails;
import com.training.bd.models.ItemFromWeb;

public interface ItemDAO {
	public ItemDetails getItemDetails(int itemID);
	public List<Item> getItemList();
/*	public void saveItem(ItemFromWeb item);
	public List<Item> getItemList();
	public Item getItem(int itemID);*/
}
