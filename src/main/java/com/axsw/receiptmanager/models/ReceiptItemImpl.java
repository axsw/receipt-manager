package com.axsw.receiptmanager.models;

import java.math.BigDecimal;

class ReceiptItemImpl implements ReceiptItem {

	private int quantity;
	private boolean isImported;
	private String name;
	private BigDecimal totalAmount;

	public ReceiptItemImpl(int quantity, String name, BigDecimal totalAmount) {
		this.quantity = quantity;
		this.name = name;
		this.totalAmount = totalAmount;
	}

	public ReceiptItemImpl() {
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

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
