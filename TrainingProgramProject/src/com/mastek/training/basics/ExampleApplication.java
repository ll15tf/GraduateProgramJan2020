package com.mastek.training.basics;

public class ExampleApplication {
	
	public static void main(String[] args) {
		
		int maxResult=0;
		
		maxResult = SolutionProvider.getMaxNumber(1, 2);
		System.out.println("Max Result is " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(20, 7);
		System.out.println("Max Result is " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(30, -100);
		System.out.println("Max Result is " + maxResult);
		
		maxResult = SolutionProvider.getMaxNumber(30, 30);
		System.out.println("Max Result is " + maxResult);
	}
	
}
