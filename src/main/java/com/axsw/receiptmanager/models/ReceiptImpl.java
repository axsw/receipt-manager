package com.axsw.receiptmanager.models;

import java.math.BigDecimal;
import java.util.List;

class ReceiptImpl implements Receipt {

	private List<ReceiptItem> items;
	private BigDecimal taxesAmount;
	private BigDecimal totalAmount;

	public ReceiptImpl(List<ReceiptItem> items, BigDecimal taxesAmount, BigDecimal totalAmount) {
		this.items = items;
		this.taxesAmount = taxesAmount;
		this.totalAmount = totalAmount;
	}

	public ReceiptImpl() {
	}

	public List<ReceiptItem> getItems() {
		return items;
	}

	public void setItems(List<ReceiptItem> items) {
		this.items = items;
	}

	public BigDecimal getTaxesAmount() {
		return taxesAmount;
	}

	public void setTaxesAmount(BigDecimal taxesAmount) {
		this.taxesAmount = taxesAmount;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

}
