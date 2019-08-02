package com.axsw.receiptmanager.models;

import java.math.BigDecimal;

public interface ShoppingBasketItem {

	int getQuantity();

	void setQuantity(int quantity);

	boolean isImported();

	void setImported(boolean isImported);

	String getName();

	void setName(String name);

	BigDecimal getPrice();

	void setPrice(BigDecimal price);

}