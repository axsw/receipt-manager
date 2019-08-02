package com.axsw.receiptmanager.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import com.axsw.receiptmanager.models.ItemType;

//TODO add logging
class TaxServiceImpl implements TaxService {

	private final Map<ItemType, Boolean> basicTaxableMap;

	public TaxServiceImpl() {
		basicTaxableMap = new HashMap<ItemType, Boolean>();
		basicTaxableMap.put(ItemType.GENERIC, true);
		basicTaxableMap.put(ItemType.BOOK, false);
		basicTaxableMap.put(ItemType.FOOD, false);
		basicTaxableMap.put(ItemType.MEDICAL, false);
	}

	public BigDecimal getItemBasicTaxAmount(ItemType itemType, BigDecimal price) {
		if (isItemBasicTaxable(itemType)) {
			return round0_05(price.multiply(new BigDecimal("0.10")));
		} else {
			return new BigDecimal(0);
		}
	}

	public BigDecimal getItemImportTaxAmount(boolean isImportedItem, BigDecimal price) {
		if (isImportedItem) {
			return round0_05(price.multiply(new BigDecimal("0.05")));
		} else {
			return new BigDecimal(0);
		}
	}

	private boolean isItemBasicTaxable(ItemType itemType) {
		// TODO implement input validation!
		// TODO check if the map contains the key; if not, take the appropriate action
		// (return default value or throw an exception?)

		return basicTaxableMap.get(itemType);
	}

	private static BigDecimal round0_05(BigDecimal d) {
		return d.multiply(new BigDecimal(20)).setScale(0, RoundingMode.HALF_UP).multiply(new BigDecimal("0.05"));
	}
}
