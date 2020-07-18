package com.systa.algo.sorting;

import java.util.Arrays;

// Insertion sort works the way we sort playing cards in our hands.
public class InsertionSort {
	
	public static void sort(int[] arr){
		
		for(int i = 1; i < arr.length; i++){
			
			int j = i - 1;
			int key = arr[i];
			
			while(j >= 0 && arr[j] > key){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		Arrays.stream(arr).forEach( x -> System.out.print(x + " "));
	}

	public static void main(String[] args) {
		int[] array = new int[]{5, 2, 4, 3, 6, 1};
		sort(array);
	}

}
