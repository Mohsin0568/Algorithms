/**
 * 
 */
package com.systa.algo.revision.sorting;

import java.util.Arrays;

/**
 * @author mohsin
 * Stable Selection Sort
 *
 */
public class SelectionSort {

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
		
		for(int i = 0 ; i < size-1; i++) {
			
			int min = i;
			
			for(int j = i+1 ; j < size; j++) {
				if(unsortedArray[j] < unsortedArray[min])
					min = j;
			}
			
			int key = unsortedArray[min];
			
			while(min > i) {
				unsortedArray[min] = unsortedArray[min-1];
				min--;
			}
			unsortedArray[i] = key;
		}
		
		return unsortedArray;
		
	}

}
