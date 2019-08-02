package com.axsw.receiptmanager.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.axsw.receiptmanager.models.ItemType;
import com.axsw.receiptmanager.models.ModelFactory;
import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ReceiptItem;
import com.axsw.receiptmanager.models.ShoppingBasket;
import com.axsw.receiptmanager.models.ShoppingBasketItem;

//TODO add logging
class ReceiptServiceImpl implements ReceiptService {

	public Receipt processShoppingBasket(ShoppingBasket basket) {
		ItemTypeService itemTypeService = ServiceFactory.getInstance().createItemTypeService();
		TaxService taxService = ServiceFactory.getInstance().createTaxService();

		List<ReceiptItem> receiptItems = new ArrayList<ReceiptItem>();
		BigDecimal receiptTaxesAmount = new BigDecimal(0);
		BigDecimal receiptTotalAmount = new BigDecimal(0);

		for (ShoppingBasketItem basketItem : basket.getItems()) {
			ItemType itemType = itemTypeService.getItemType(basketItem.getName());

			BigDecimal basicTaxAmount = taxService.getItemBasicTaxAmount(itemType, basketItem.getPrice());
			BigDecimal importTaxAmount = taxService.getItemImportTaxAmount(basketItem.isImported(),
					basketItem.getPrice());

			BigDecimal receiptItemTaxesAmount = basicTaxAmount.add(importTaxAmount)
					.multiply(new BigDecimal(basketItem.getQuantity()));
			BigDecimal receiptItemTotalAmount = basketItem.getPrice().multiply(new BigDecimal(basketItem.getQuantity()))
					.add(receiptItemTaxesAmount);

			ReceiptItem receiptItem = ModelFactory.getInstance().createReceiptItem();
			receiptItem.setQuantity(basketItem.getQuantity());
			receiptItem.setImported(basketItem.isImported());
			receiptItem.setName(basketItem.getName());
			receiptItem.setTotalAmount(receiptItemTotalAmount);
			receiptItems.add(receiptItem);

			receiptTaxesAmount = receiptTaxesAmount.add(receiptItemTaxesAmount);
			receiptTotalAmount = receiptTotalAmount.add(receiptItemTotalAmount);
		}

		Receipt receipt = ModelFactory.getInstance().createReceipt();
		receipt.setItems(receiptItems);
		receipt.setTaxesAmount(receiptTaxesAmount);
		receipt.setTotalAmount(receiptTotalAmount);

		return receipt;
	}
}
