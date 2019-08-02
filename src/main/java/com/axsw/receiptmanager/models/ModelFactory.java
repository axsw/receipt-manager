package com.axsw.receiptmanager.models;

public class ModelFactory {

	private static ModelFactory instance = null;

	public static ModelFactory getInstance() {
		if (instance == null)
			synchronized (ModelFactory.class) {
				if (instance == null) {
					instance = new ModelFactory();
				}
			}
		return instance;
	}

	public ShoppingBasketItem createShoppingBasketItem() {
		return new ShoppingBasketItemImpl();
	}

	public ShoppingBasket createShoppingBasket() {
		return new ShoppingBasketImpl();
	}

	public ReceiptItem createReceiptItem() {
		return new ReceiptItemImpl();
	}

	public Receipt createReceipt() {
		return new ReceiptImpl();
	}
}
