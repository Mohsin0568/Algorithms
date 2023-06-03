/**
 * 
 */
package com.systa.algo.revision.sorting;

import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] sortedArray = sort(new int[]{28, 5, 3, 20, 15, 1});
		Arrays.stream(sortedArray).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		sortedArray = sort(new int[]{3, 1, 2, 4, 3, 1});
		Arrays.stream(sortedArray).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		sortedArray = sort(new int[]{1, 2, 3, 4, 5, 6});
		Arrays.stream(sortedArray).forEach(x -> System.out.print(x + " "));
		System.out.println();

	}
	
	public static int[] sort(int[] unsortedArray) {
		
		int size = unsortedArray.length;
		int i;
		for(i = 0 ; i < size-1; i++) {
			boolean swap = false;
			
			for(int j = 1, k = 0; j < size-i; j++,k++) {
				
				if(unsortedArray[k] > unsortedArray[j]) {
					unsortedArray[k] = unsortedArray[k] + unsortedArray[j];
					unsortedArray[j] = unsortedArray[k] - unsortedArray[j];
					unsortedArray[k] = unsortedArray[k] - unsortedArray[j];
					swap = true;
				}
				
			}			
			if(!swap) { // if no iteration happened, means array is sorted
				
				break;
			}
		}
		System.out.println("Sorted with iteration " + i);
		return unsortedArray;
	}

}
