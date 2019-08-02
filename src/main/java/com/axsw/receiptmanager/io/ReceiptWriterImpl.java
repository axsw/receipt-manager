package com.axsw.receiptmanager.io;

import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ReceiptItem;

//TODO add logging
class ReceiptWriterImpl implements ReceiptWriter {

	public String receiptItemToString(ReceiptItem item) {
		// examples of the output string
		// 1 book: 12.49
		// 1 imported music CD: 15.00

		return String.format("%1$s %2$s%3$s: %4$s", item.getQuantity(), item.isImported() ? "imported " : "",
				item.getName(), item.getTotalAmount());
	}

	public String receiptToString(Receipt receipt) {
		// example of the output string
		// 1 book: 12.49
		// 1 music CD: 16.49
		// 1 chocolate bar: 0.85
		// Sales Taxes: 1.50
		// Total: 29.83

		StringBuilder sb = new StringBuilder();

		for (ReceiptItem item : receipt.getItems()) {
			sb.append(receiptItemToString(item));
			sb.append("\r\n");
		}
		sb.append(String.format("Sales Taxes: %1$s", receipt.getTaxesAmount()));
		sb.append("\r\n");
		sb.append(String.format("Total: %1$s", receipt.getTotalAmount()));

		return sb.toString();
	}
}
