package com.systa.algo.sorting;

import java.util.Arrays;

/* Bubble sort works by repeatedly swapping the adjacent elements if they are in wrong order*/

public class BubbleSort {
	
	
	public static void sort(int[] array){
		
		for(int i = 0 ; i < array.length-1; i++){
			
			for(int j = 0 ; j < array.length-1; j++){
				
				if(array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;				
 				}
			}
			
			System.out.print("After step " + (i+1) + "--> ");
			Arrays.stream(array).forEach( x -> System.out.print(x + " "));
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		int[] array = new int[]{5, 2, 4, 3, 6, 1};
		sort(array);		
	}

}
