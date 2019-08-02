package com.axsw.receiptmanager.io;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.axsw.receiptmanager.models.ModelFactory;
import com.axsw.receiptmanager.models.ShoppingBasket;
import com.axsw.receiptmanager.models.ShoppingBasketItem;

//TODO add logging
class ShoppingBasketReaderImpl implements ShoppingBasketReader {

	public ShoppingBasketItem parseShoppingBasketItem(String s) {
		// examples of the input string
		// 1 book at 12.49
		// 1 box of imported chocolates at 11.25

		// TODO implement input validation!

		boolean isImported = s.contains("imported");
		String[] words = s.split(" ");
		int quantity = Integer.parseInt(words[0]);
		BigDecimal price = new BigDecimal(words[words.length - 1]);
		int nameStartIndex = 1;
		int nameEndIndex = words.length - 3;
		StringBuilder nameSb = new StringBuilder();
		for (int i = nameStartIndex; i <= nameEndIndex; i++) {
			String word = words[i];
			if (word.equals("imported")) {
				continue;
			}
			if (nameSb.length() > 0) {
				nameSb.append(" ");
			}
			nameSb.append(word);
		}

		ShoppingBasketItem item = ModelFactory.getInstance().createShoppingBasketItem();
		item.setQuantity(quantity);
		item.setImported(isImported);
		item.setName(nameSb.toString());
		item.setPrice(price);
		return item;
	}

	public ShoppingBasket parseShoppingBasket(String s) {
		// example of the input string
		// 1 book at 12.49
		// 1 music CD at 14.99
		// 1 chocolate bar at 0.85

		// TODO implement input validation!

		List<ShoppingBasketItem> items = new ArrayList<ShoppingBasketItem>();
		String[] lines = s.split("\\r?\\n");
		for (String line : lines) {
			ShoppingBasketItem item = parseShoppingBasketItem(line);
			items.add(item);
		}

		ShoppingBasket basket = ModelFactory.getInstance().createShoppingBasket();
		basket.setItems(items);
		return basket;
	}
}
