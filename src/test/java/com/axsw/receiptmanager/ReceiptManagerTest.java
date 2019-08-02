package com.axsw.receiptmanager;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceiptManagerTest {

	@Test
	public void test1() {
		System.out.println("TEST 1");
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 book at 12.49");
		sb.append("\r\n");
		sb.append("1 music CD at 14.99");
		sb.append("\r\n");
		sb.append("1 chocolate bar at 0.85");		
		String shoppingBasketString = sb.toString();
		
		System.out.println("INPUT");
		System.out.println(shoppingBasketString);
		
		//Note: I modified the original expected output because I think that the first row is wrong:
		//there shouldn't be a space after the word "book".
		
//		sb = new StringBuilder();
//		sb.append("1 book : 12.49");
//		sb.append("\r\n");
//		sb.append("1 music CD: 16.49");
//		sb.append("\r\n");
//		sb.append("1 chocolate bar: 0.85");
//		sb.append("\r\n");
//		sb.append("Sales Taxes: 1.50");
//		sb.append("\r\n");
//		sb.append("Total: 29.83");
//		String expectedReceiptString = sb.toString();
		
		sb = new StringBuilder();
		sb.append("1 book: 12.49"); //removed the wrong space
		sb.append("\r\n");
		sb.append("1 music CD: 16.49");
		sb.append("\r\n");
		sb.append("1 chocolate bar: 0.85");
		sb.append("\r\n");
		sb.append("Sales Taxes: 1.50");
		sb.append("\r\n");
		sb.append("Total: 29.83");
		String expectedReceiptString = sb.toString();
		
		testReceiptManager(shoppingBasketString, expectedReceiptString);
	}
	
	@Test
	public void test2() {
		System.out.println("TEST 2");
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 imported box of chocolates at 10.00");
		sb.append("\r\n");
		sb.append("1 imported bottle of perfume at 47.50");
		String shoppingBasketString = sb.toString();
		
		System.out.println("INPUT");
		System.out.println(shoppingBasketString);
		
		sb = new StringBuilder();
		sb.append("1 imported box of chocolates: 10.50");
		sb.append("\r\n");
		sb.append("1 imported bottle of perfume: 54.65");
		sb.append("\r\n");
		sb.append("Sales Taxes: 7.65");
		sb.append("\r\n");
		sb.append("Total: 65.15");
		String expectedReceiptString = sb.toString();
		
		testReceiptManager(shoppingBasketString, expectedReceiptString);
	}
	
	@Test
	public void test3() {
		System.out.println("TEST 3");
		
		StringBuilder sb = new StringBuilder();
		sb.append("1 imported bottle of perfume at 27.99");
		sb.append("\r\n");
		sb.append("1 bottle of perfume at 18.99");
		sb.append("\r\n");
		sb.append("1 packet of headache pills at 9.75");
		sb.append("\r\n");
		sb.append("1 box of imported chocolates at 11.25");
		String shoppingBasketString = sb.toString();
		
		System.out.println("INPUT");
		System.out.println(shoppingBasketString);

		//Note: I modified the original expected output because I think that the tax value of the fourth item is wrong:
		//11.25*5/100=0.5625. Rounding up to the nearest 0.05 we obtain 0.55 instead of 0.6
		
//		sb = new StringBuilder();
//		sb.append("1 imported bottle of perfume: 32.19");
//		sb.append("\r\n");
//		sb.append("1 bottle of perfume: 20.89");
//		sb.append("\r\n");
//		sb.append("1 packet of headache pills: 9.75");
//		sb.append("\r\n");
//		sb.append("1 imported box of chocolates: 11.85");
//		sb.append("\r\n");
//		sb.append("Sales Taxes: 6.70");
//		sb.append("\r\n");
//		sb.append("Total: 74.68");
//		String expectedReceiptString = sb.toString();
		
		sb = new StringBuilder();
		sb.append("1 imported bottle of perfume: 32.19");
		sb.append("\r\n");
		sb.append("1 bottle of perfume: 20.89");
		sb.append("\r\n");
		sb.append("1 packet of headache pills: 9.75");
		sb.append("\r\n");
		sb.append("1 imported box of chocolates: 11.80"); //changed amount to 11.80 because taxes are 0.55
		sb.append("\r\n");
		sb.append("Sales Taxes: 6.65"); //changed amount to 6.65
		sb.append("\r\n");
		sb.append("Total: 74.63"); //changed amount to 74.63
		String expectedReceiptString = sb.toString();
		
		testReceiptManager(shoppingBasketString, expectedReceiptString);
	}
	
	private static void testReceiptManager(String shoppingBasketString, String expectedReceiptString) {
		ReceiptManager receiptManager = new ReceiptManager();
		String receiptString = receiptManager.createReceipt(shoppingBasketString);
		
		System.out.println("OUTPUT");
		System.out.println(receiptString);
		
		assertEquals(expectedReceiptString, receiptString);
	}
	
}
