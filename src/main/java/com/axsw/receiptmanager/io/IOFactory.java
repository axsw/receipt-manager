package com.axsw.receiptmanager.io;

public class IOFactory {

	private static IOFactory instance = null;

	public static IOFactory getInstance() {
		if (instance == null)
			synchronized (IOFactory.class) {
				if (instance == null) {
					instance = new IOFactory();
				}
			}
		return instance;
	}

	public ReceiptWriter createReceiptWriter() {
		return new ReceiptWriterImpl();
	}

	public ShoppingBasketReader createShoppingBasketReader() {
		return new ShoppingBasketReaderImpl();
	}
}
