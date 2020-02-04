package com.mastek.training.packone;

public class SimpleClass {

	private int privateNumber = 10;
	int defaultNumber = 10;
	protected int protectedNumber = 10;
	public int publicNumber = 10;
	
	
	public static void main(String [] args) {
		SimpleClass sc1 = new SimpleClass ();
		System.out.println("Private Number: "+sc1.privateNumber+ ", Default Number: "+sc1.defaultNumber+ ", Protected Number: "+sc1.protectedNumber+", Public Number: "+sc1.publicNumber);
	}
}
// to show that in the same class we can access all the types of members of the class