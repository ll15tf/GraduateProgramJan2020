package com.mastek.training.myshop;

public interface ShoppingCart <I> {
	
	public int addItem (I i);
	public int removeItem (I i);
	public void printItems ();
	public int getTotalPrice(double tax, double discountPercentage);
	
	
	
	
}
