package com.systa.algo.sorting;

import java.util.Arrays;

public class SelectionSort {
	
	public static void sort(int[] array){
		
		for(int i = 0 ; i < array.length -1; i++){
			
			// find the mininum number in the array from i to length
			int min = i;
			for(int j = i+1; j < array.length; j++){
				if(array[min] > array[j])
					min = j;
			}
			
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
		Arrays.stream(array).forEach( x -> System.out.print(x + " "));
	}

	public static void main(String[] args) {
		int[] array = new int[]{5, 2, 4, 3, 6, 1};
		sort(array);
	}

}
