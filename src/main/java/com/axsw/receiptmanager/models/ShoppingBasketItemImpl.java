package com.axsw.receiptmanager.models;

import java.math.BigDecimal;

class ShoppingBasketItemImpl implements ShoppingBasketItem {

	private int quantity;
	private boolean isImported;
	private String name;
	private BigDecimal price;

	public ShoppingBasketItemImpl(int quantity, boolean isImported, String name, BigDecimal price) {
		this.quantity = quantity;
		this.isImported = isImported;
		this.name = name;
		this.price = price;
	}

	public ShoppingBasketItemImpl() {
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
