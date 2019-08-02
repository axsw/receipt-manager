package com.axsw.receiptmanager.io;

import com.axsw.receiptmanager.models.ShoppingBasket;
import com.axsw.receiptmanager.models.ShoppingBasketItem;

public interface ShoppingBasketReader {

	ShoppingBasketItem parseShoppingBasketItem(String s);

	ShoppingBasket parseShoppingBasket(String s);

}