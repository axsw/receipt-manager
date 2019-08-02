package com.axsw.receiptmanager.services;

import java.math.BigDecimal;

import com.axsw.receiptmanager.models.ItemType;

public interface TaxService {

	BigDecimal getItemBasicTaxAmount(ItemType itemType, BigDecimal price);

	BigDecimal getItemImportTaxAmount(boolean isImportedItem, BigDecimal price);

}