package com.mastek.training.packone;

// a class can inherit from an interface using implements keyword 
// One class can implement more than one interface
// interfaces uses the class object for implementing it's behaviours hence it is used frequent;y as it saves additional number of objects being created
public class Rectangle implements Shape{

	private int length; 
	private int breath;
	
	//getter setters
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getBreath() {
		return breath;
	}
	public void setBreath(int breath) {
		this.breath = breath;
	}
	
	//Override all methods from implemented interface
	@Override
	public double getArea() {
		return getLength()*getBreath();
	}
	@Override
	public double getPerimeter() {
		return 2*(getLength()+getBreath());
	} 
	
	
}
