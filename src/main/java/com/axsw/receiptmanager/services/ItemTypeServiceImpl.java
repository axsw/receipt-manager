package com.axsw.receiptmanager.services;

import java.util.HashMap;
import java.util.Map;

import com.axsw.receiptmanager.models.ItemType;

//TODO add logging
class ItemTypeServiceImpl implements ItemTypeService {

	private final Map<String, ItemType> itemTypeMap;

	public ItemTypeServiceImpl() {
		itemTypeMap = new HashMap<String, ItemType>();
		itemTypeMap.put("book", ItemType.BOOK);
		itemTypeMap.put("music CD", ItemType.GENERIC);
		itemTypeMap.put("chocolate bar", ItemType.FOOD);
		itemTypeMap.put("box of chocolates", ItemType.FOOD);
		itemTypeMap.put("bottle of perfume", ItemType.GENERIC);
		itemTypeMap.put("packet of headache pills", ItemType.MEDICAL);
	}

	public ItemType getItemType(String itemName) {
		// TODO implement input validation!
		// TODO check if the map contains the key; if not, take the appropriate action
		// (return default value or throw an exception?)
		
		return itemTypeMap.get(itemName);
	}
}
