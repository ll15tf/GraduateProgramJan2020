package com.mastek.training.packtwo;

import com.mastek.training.packone.SimpleClass;

public class DerivedClass extends SimpleClass {

	public static void main(String [] args) {
		DerivedClass sc1 = new DerivedClass ();
		System.out.println("Private Number: Not Available Outside Class in which it was Created"+ ", Default Number: Not Available in different Package"+ ", Protected Number: "+sc1.protectedNumber+", Public Number: "+sc1.publicNumber);
	}
		
}
// can access the protected number as it is a child of the initial class in another package