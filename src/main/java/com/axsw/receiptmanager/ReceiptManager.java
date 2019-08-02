package com.axsw.receiptmanager;

import com.axsw.receiptmanager.io.IOFactory;
import com.axsw.receiptmanager.io.ReceiptWriter;
import com.axsw.receiptmanager.io.ShoppingBasketReader;
import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ShoppingBasket;
import com.axsw.receiptmanager.services.ReceiptService;
import com.axsw.receiptmanager.services.ServiceFactory;

//TODO add logging
public class ReceiptManager {

	public String createReceipt(String shoppingBasketString) {
		ShoppingBasketReader shoppingBasketReader = IOFactory.getInstance().createShoppingBasketReader();
		ShoppingBasket shoppingBasket = shoppingBasketReader.parseShoppingBasket(shoppingBasketString);

		ReceiptService receiptService = ServiceFactory.getInstance().createReceiptService();
		Receipt receipt = receiptService.processShoppingBasket(shoppingBasket);

		ReceiptWriter receiptWriter = IOFactory.getInstance().createReceiptWriter();
		String receiptString = receiptWriter.receiptToString(receipt);

		return receiptString;
	}
}
