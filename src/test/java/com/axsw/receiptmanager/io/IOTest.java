package com.axsw.receiptmanager.io;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.axsw.receiptmanager.models.ModelFactory;
import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ReceiptItem;
import com.axsw.receiptmanager.models.ShoppingBasket;
import com.axsw.receiptmanager.models.ShoppingBasketItem;

public class IOTest {

	@Test
	public void testWriteReceiptItem01() {
		ReceiptItem item = ModelFactory.getInstance().createReceiptItem();
		item.setQuantity(2);
		item.setImported(false);
		item.setName("receipt item 1");
		item.setTotalAmount(new BigDecimal("1.17"));

		ReceiptWriter receiptWriter = IOFactory.getInstance().createReceiptWriter();

		String receiptItemString = receiptWriter.receiptItemToString(item);

		String expectedReceiptItemString = "2 receipt item 1: 1.17";

		assertEquals(expectedReceiptItemString, receiptItemString);
	}

	@Test
	public void testWriteReceipt01() {
		List<ReceiptItem> items = new ArrayList<ReceiptItem>();

		ReceiptItem item = ModelFactory.getInstance().createReceiptItem();
		item.setQuantity(3);
		item.setImported(false);
		item.setName("receipt item 1");
		item.setTotalAmount(new BigDecimal("1.17"));
		items.add(item);

		item = ModelFactory.getInstance().createReceiptItem();
		item.setQuantity(1);
		item.setImported(true);
		item.setName("receipt item 2");
		item.setTotalAmount(new BigDecimal("2.29"));
		items.add(item);

		Receipt receipt = ModelFactory.getInstance().createReceipt();
		receipt.setItems(items);
		receipt.setTaxesAmount(new BigDecimal("5.23"));
		receipt.setTotalAmount(new BigDecimal("10.23"));

		ReceiptWriter receiptWriter = IOFactory.getInstance().createReceiptWriter();

		String receiptString = receiptWriter.receiptToString(receipt);

		StringBuilder sb = new StringBuilder();
		sb.append("3 receipt item 1: 1.17");
		sb.append("\r\n");
		sb.append("1 imported receipt item 2: 2.29");
		sb.append("\r\n");
		sb.append("Sales Taxes: 5.23");
		sb.append("\r\n");
		sb.append("Total: 10.23");
		String expectedReceiptString = sb.toString();

		assertEquals(expectedReceiptString, receiptString);
	}

	@Test
	public void testReadShoppingBasketItem01() {
		ShoppingBasketReader shoppingBasketReader = IOFactory.getInstance().createShoppingBasketReader();

		ShoppingBasketItem item = shoppingBasketReader.parseShoppingBasketItem("1 book at 12.49");

		assertEquals(1, item.getQuantity());
		assertEquals(false, item.isImported());
		assertEquals("book", item.getName());
		assertEquals(new BigDecimal("12.49"), item.getPrice());
	}

	@Test
	public void testReadShoppingBasketItem02() {
		ShoppingBasketReader shoppingBasketReader = IOFactory.getInstance().createShoppingBasketReader();

		ShoppingBasketItem item = shoppingBasketReader.parseShoppingBasketItem("1 box of imported chocolates at 11.25");

		assertEquals(1, item.getQuantity());
		assertEquals(true, item.isImported());
		assertEquals("box of chocolates", item.getName());
		assertEquals(new BigDecimal("11.25"), item.getPrice());
	}

	@Test
	public void testReadShoppingBasket01() {
		ShoppingBasketReader shoppingBasketReader = IOFactory.getInstance().createShoppingBasketReader();

		StringBuilder sb = new StringBuilder();
		sb.append("1 imported bottle of perfume at 27.99");
		sb.append("\r\n");
		sb.append("1 bottle of perfume at 18.99");
		sb.append("\r\n");
		sb.append("1 packet of headache pills at 9.75");
		sb.append("\r\n");
		sb.append("1 box of imported chocolates at 11.25");

		ShoppingBasket basket = shoppingBasketReader.parseShoppingBasket(sb.toString());

		assertEquals(4, basket.getItems().size());

		ShoppingBasketItem item = basket.getItems().get(0);
		assertEquals(1, item.getQuantity());
		assertEquals(true, item.isImported());
		assertEquals("bottle of perfume", item.getName());
		assertEquals(new BigDecimal("27.99"), item.getPrice());

		item = basket.getItems().get(1);
		assertEquals(1, item.getQuantity());
		assertEquals(false, item.isImported());
		assertEquals("bottle of perfume", item.getName());
		assertEquals(new BigDecimal("18.99"), item.getPrice());

		item = basket.getItems().get(2);
		assertEquals(1, item.getQuantity());
		assertEquals(false, item.isImported());
		assertEquals("packet of headache pills", item.getName());
		assertEquals(new BigDecimal("9.75"), item.getPrice());

		item = basket.getItems().get(3);
		assertEquals(1, item.getQuantity());
		assertEquals(true, item.isImported());
		assertEquals("box of chocolates", item.getName());
		assertEquals(new BigDecimal("11.25"), item.getPrice());
	}

}
