package com.mastek.training.basics;

public class ProblemOne {

	public static String getRemainder(int num1, int num2) {
		int quotient = 0;
		int remainder = 0;
		
		quotient = (num1/num2);
		remainder = (num1 % num2);
		
		return (quotient + "," +remainder);
	}

 }
	


