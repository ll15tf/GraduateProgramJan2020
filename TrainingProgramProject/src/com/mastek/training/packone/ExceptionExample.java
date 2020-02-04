package com.mastek.training.packone;

import java.util.Scanner;

public class ExceptionExample {
	
	public static void main(String[] args) {
		int num1=0, num2=0, result=0;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter Num1: ");
			num1 = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Num2: ");
			num2 = Integer.parseInt(sc.nextLine());
			
			result=num1/num2;
			System.out.println("Division is: "+result);
		} 
		
		catch (NumberFormatException e) {
			e.printStackTrace(); // print the exception information
			System.err.println("Invalid Number Entered");
		// handles specific exceptions 
		}
		
		catch(Exception ex) {
			System.err.println("Exception Occured: "+ex);
			System.err.println("Exception Occured: "+ex.getMessage());
			ex.printStackTrace();
		} // handles all types of exceptions 
		
		finally {
			System.out.println("Scanner Closed");
			sc.close();
		}
		
		System.out.println("Program Completed");
	}
		
}
