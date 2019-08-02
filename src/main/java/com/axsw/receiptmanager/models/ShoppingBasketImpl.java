package com.axsw.receiptmanager.models;

import java.util.List;

class ShoppingBasketImpl implements ShoppingBasket {

	private List<ShoppingBasketItem> items;

	public ShoppingBasketImpl(List<ShoppingBasketItem> items) {
		this.items = items;
	}

	public ShoppingBasketImpl() {
	}

	public List<ShoppingBasketItem> getItems() {
		return items;
	}

	public void setItems(List<ShoppingBasketItem> items) {
		this.items = items;
	}

}
