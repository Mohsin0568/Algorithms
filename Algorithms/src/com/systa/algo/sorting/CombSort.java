package com.systa.algo.sorting;

import java.util.Arrays;

public class CombSort {

	public static void main(String[] args) {
//		int[] array = new int[]{9, 4, 6, 3, 7, 1, 2, 11, 5};
		int[] array = new int[]{8, 4, 1,56, 3, -44, 23, -6, 28, 0};
		sort(array);
	}
	
	public static void sort(int arr[]){
		
		int k = 1;
		int gap = (int) (arr.length/1.3);
		while(gap > 0){
			
			for(int i = 0, j = gap ; j < arr.length; i++, j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			System.out.println("After " + k + " iteration with gap " + gap);
			Arrays.stream(arr).forEach( x -> System.out.print(x + " "));
			System.out.println();
			gap = (int) (gap/1.3);
			k++;
		}
	}
}
