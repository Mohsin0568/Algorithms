/**
 * 
 */
package com.systa.algo.interview.practise;

/**
 * @author mohsin
 *
 */
public class NumbersUtil {

	public static void main(String[] args) {
		NumbersUtil util = new NumbersUtil();
		util.reverseNumber(105);

	}
	
	// Reversing a number
	public void reverseNumber(int number) {
		// 365
		
		int reverseNumber = 0;
		while(number != 0) {
			int temp = number % 10;
			reverseNumber = reverseNumber * 10 + temp;
			number = number / 10;
		}
		
		System.out.println(reverseNumber);
		
	}

}
