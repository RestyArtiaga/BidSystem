package com.training.bd.services;

import java.util.List;

import com.training.bd.models.Item;
import com.training.bd.webModels.ItemDetails;
import com.training.bd.webModels.ItemFromWeb;
import com.training.bd.webModels.StatusObject;

public interface ItemService {
	public ItemDetails getItemDetails(int itemID);
	public List<Item> getItemList();
	public Item saveItem(ItemFromWeb item);
	public StatusObject deleteItem(int itemID);
	public Item updateItem(ItemFromWeb item);
}
