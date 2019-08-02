package com.axsw.receiptmanager.models;

import java.math.BigDecimal;

public interface ReceiptItem {

	int getQuantity();

	void setQuantity(int quantity);

	boolean isImported();

	void setImported(boolean isImported);

	String getName();

	void setName(String name);

	BigDecimal getTotalAmount();

	void setTotalAmount(BigDecimal totalAmount);

}