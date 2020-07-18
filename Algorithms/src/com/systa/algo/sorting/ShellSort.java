package com.systa.algo.sorting;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		int[] array = new int[]{8, 4, 1,56, 3, -44, 23, -6, 28, 0};
		sort(array);
	}
	
	public static void sort(int[] arr){
		
		int size = arr.length;
		for(int gap = size/2; gap > 0; gap /= 2){
			
			for(int i = gap; i < size; i++){
				
				int temp = arr[i]; 
				  
                int j; 
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) 
                    arr[j] = arr[j - gap]; 
  
                arr[j] = temp;
			}
		}
		
		Arrays.stream(arr).forEach( x -> System.out.print(x + " "));
	}

}
