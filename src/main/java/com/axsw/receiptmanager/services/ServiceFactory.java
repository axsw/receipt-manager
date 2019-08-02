package com.axsw.receiptmanager.services;

public class ServiceFactory {

	private static ServiceFactory instance = null;

	public static ServiceFactory getInstance() {
		if (instance == null)
			synchronized (ServiceFactory.class) {
				if (instance == null) {
					instance = new ServiceFactory();
				}
			}
		return instance;
	}

	public ItemTypeService createItemTypeService() {
		return new ItemTypeServiceImpl();
	}

	public TaxService createTaxService() {
		return new TaxServiceImpl();
	}

	public ReceiptService createReceiptService() {
		return new ReceiptServiceImpl();
	}
}
