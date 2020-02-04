package com.mastek.training.basics;

public class ProblemThree {
	public static double AreaOfRectangle(double side1, double side2) {
		double area = 0;
		
		if (side1 == side2) {
			area = Math.pow(side1, 2); 
		}
		else {
			area = side1*side2; }
		
	return area; 
		}
	}

