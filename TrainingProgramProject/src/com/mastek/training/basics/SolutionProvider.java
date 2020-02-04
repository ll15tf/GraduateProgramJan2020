package com.mastek.training.basics;

public class SolutionProvider {
/* 
 * notes are done in this way 
 * not code but for developers to understand
 */
	// public static <return data-type><name of function>(<parameter1-type><parameter_name>, ...)
	public static int getMaxNumber(int num1, int num2) { //declare inputs as parameters
		int max=0; // declare output as local variable 
		if (num1>num2) {
			max=num1;
		} else { 
			max=num2;
		}
		return max; //return the result to the caller
	}
}
