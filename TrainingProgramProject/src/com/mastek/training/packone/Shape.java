package com.mastek.training.packone;


//interface: a type of which contain only method declarations and constants 

// the interface does not extend any existing type 

public interface Shape {
	// no constructors can be used in interfaces
	
	// all variables are final and static 
	double PI = Math.PI; 

	// all methods are abstract 
	public double getArea(); 
	public double getPerimeter();
	
}
