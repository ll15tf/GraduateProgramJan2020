package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class AnotherClass {

	public static void main(String [] args) {
		SimpleClass sc1 = new SimpleClass ();
		System.out.println("Private Number: Not Available Outside Class in which it was Created"+ ", Default Number: Not Available in different Package"+ ", Protected Number Not Available in different Package: "+", Public Number: "+sc1.publicNumber);
	}
	
}
// In another class in the same package we can access all the members of the class minus the private member. Can use getter setters to overcome this issue. 
