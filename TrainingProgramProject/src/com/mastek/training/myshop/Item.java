package com.mastek.training.myshop;

public class Item 
		implements Comparable<Item> //it provides default sorting fpr tree set
{

	private int itemId; 
	private String itemName; 
	private int itemQuantity; 
	private double unitPrice;
	
	//constructor
	public Item() {
		// TODO Auto-generated constructor stub
	}
	

	public Item(int itemId, String itemName, double unitPrice, int itemQuantity) {

		setItemId(itemId);
		setItemName(itemName);
		setUnitPrice(unitPrice);
		setItemQuantity(itemQuantity);
		
	}
	
//constructor 
	public Item(int itemId) {
		setItemId(itemId);
	}
	
	
	//getters and setters 
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity + ", unitPrice="
				+ unitPrice + "]";
	}

	//generate hash code for item id 
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + itemId;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemId != other.itemId)
			return false;
		return true;
	}

// TreeSet uses to compare for default order
	@Override
	public int compareTo(Item anotherItem) {
		// return a number 
		// positive means that the object is greater than another item, 
		//0 is equal to another item and 
		//negative means that the object is less than another item
		System.out.println("Comparing Items");
		return this.getItemId()-anotherItem.getItemId(); // has to be on unique key
	}


	

		
}
