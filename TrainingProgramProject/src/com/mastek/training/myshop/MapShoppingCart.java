package com.mastek.training.myshop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapShoppingCart implements ShoppingCart<Item> {
	
	
	Map<Integer, Item> items;
	
	
	public MapShoppingCart() {
		//items = new HashMap<>(); // maintain random entries for the collection
		items = new TreeMap<>(); // tree map sorts all the entries using keys :: itemID 
	}

	@Override
	public int addItem(Item i) { // map.put(key,value)
		items.put(i.getItemId(), i);
		return items.size();
	}

	@Override
	public int removeItem(Item i) { //map.remove key
		items.remove(i.getItemId());
		return items.size();
	}

	@Override
	public void printItems() {
		System.out.println("Items in Cart");
		for (Integer itemId: items.keySet()) {//get all the keys from the maps 
			Item i =items.get(itemId); // gets the value from the map using the key 
			System.out.println(i);
		}

	}

	@Override
	public int getTotalPrice(double tax, double discountPercentage) {
		// TODO Auto-generated method stub
		return 0;
	}

}
