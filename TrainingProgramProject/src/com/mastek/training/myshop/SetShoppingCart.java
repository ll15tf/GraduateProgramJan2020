package com.mastek.training.myshop;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class SetShoppingCart implements ShoppingCart<Item> {

	Set<Item> items; 
	
	
	public SetShoppingCart() {
		//using hash set to manage unique items in random order
		//items = new HashSet<>(); // diamond operator with keyword, since jdk 1.7
		//new HashSet<Item>();
		
		items = new TreeSet<>();
		
	}
	
	
	@Override
	public int addItem(Item i) {
		items.add(i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) {
		items.remove(i);
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in Cart");
		for(Item item : items) {
			System.out.println(item);
		}

	}

	@Override
	public int getTotalPrice(double tax, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
