package com.axsw.receiptmanager.models;

import java.util.List;

public interface ShoppingBasket {

	List<ShoppingBasketItem> getItems();

	void setItems(List<ShoppingBasketItem> items);

}