package com.axsw.receiptmanager.services;

import com.axsw.receiptmanager.models.Receipt;
import com.axsw.receiptmanager.models.ShoppingBasket;

public interface ReceiptService {

	Receipt processShoppingBasket(ShoppingBasket basket);

}