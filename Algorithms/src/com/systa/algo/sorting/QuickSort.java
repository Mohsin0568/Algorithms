package com.systa.algo.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] array = new int[]{9, 4, 6, 3, 7, 1, 2, 11, 5};
		QuickSort sorting = new QuickSort();
		sorting.sort(array, 0, array.length-1);
		Arrays.stream(array).forEach( x -> System.out.print(x + " "));
	}
	
	/*
	 * arr array element to sort
	 * i -- start index of an array
	 * k -- last index of an array
	 */
	public void sort(int[] arr, int i, int k){
		
		if(i > k)
			return;
		
		int pivot = getPivotal(arr, i, k);
		sort(arr, i, pivot-1);
		sort(arr, pivot+1, k);
		
	}
	
	/*
	 * arr array element to sort
	 * i -- start index of an array
	 * k -- last index of an array
	 */
	private int getPivotal(int[] arr, int i, int k){
		int j = i-1;
		while(i <= k){
			if(arr[i] <= arr[k]){
				int tmp = arr[i];
				arr[i] = arr[++j];
				arr[j] = tmp;				
			}
			i++;
		}
		return j;
	}

}
