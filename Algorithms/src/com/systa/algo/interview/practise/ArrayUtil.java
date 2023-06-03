/**
 * 
 */
package com.systa.algo.interview.practise;

import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class ArrayUtil {

	public static void main(String[] args) {
	
		int[] originalArray = new int[] {1,2,3,4,5,6,7};
		ArrayUtil util = new ArrayUtil();
		util.reversingAnArray(originalArray);
		util.printArray(originalArray);
	}
	
	public void printArray(int[] originalArray) {
		Arrays.stream(originalArray).forEach(System.out :: println);
	}
	
	// Reversing an array in place
	public void reversingAnArray(int[] originalArray) {
		
		int itrLimit = (originalArray.length/2)-1;
		
		int i = 0;
		while (i <= itrLimit) {
			int temp = originalArray[i];
			originalArray[i] = originalArray[originalArray.length-1-i];
			originalArray[originalArray.length-1-i] = temp;
			i++;
		}
	}

}
