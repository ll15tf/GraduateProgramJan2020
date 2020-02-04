package com.mastek.training.packone;

public class DerivedClass extends SimpleClass {

	public static void main(String [] args) {
		DerivedClass sc1 = new DerivedClass ();
		System.out.println("Private Number: Not Available Outside Class in which it was Created"+ ", Default Number: "+sc1.defaultNumber+ ", Protected Number: "+sc1.protectedNumber+", Public Number: "+sc1.publicNumber);
	}
		
}
