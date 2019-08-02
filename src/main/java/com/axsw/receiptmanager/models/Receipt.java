package com.axsw.receiptmanager.models;

import java.math.BigDecimal;
import java.util.List;

public interface Receipt {

	List<ReceiptItem> getItems();

	void setItems(List<ReceiptItem> items);

	BigDecimal getTaxesAmount();

	void setTaxesAmount(BigDecimal taxesAmount);

	BigDecimal getTotalAmount();

	void setTotalAmount(BigDecimal totalAmount);

}