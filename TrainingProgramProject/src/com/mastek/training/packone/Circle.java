package com.mastek.training.packone;

public class Circle implements Shape {

	private int radius;

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		
		return Shape.PI*(getRadius()*getRadius());
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*Shape.PI*getRadius();
	} 
	
		
}
