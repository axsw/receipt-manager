package com.axsw.receiptmanager.io;

import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ReceiptItem;

public interface ReceiptWriter {

	String receiptItemToString(ReceiptItem item);

	String receiptToString(Receipt receipt);

}