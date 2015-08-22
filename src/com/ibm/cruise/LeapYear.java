package com.ibm.cruise;

public class LeapYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isLeapYear(1996));

	}
	
	public static boolean isLeapYear(int year){
		return (year%4==0 && year % 100 != 0 || year % 400 ==0);
	}

}
