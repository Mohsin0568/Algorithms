package com.systa.algo.interview.practise.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] {10, 9, 5, 6, 3, 2, 4};
		QuickSort sort = new QuickSort();
		sort.sort(arr, 0 , arr.length-1);
		Arrays.stream(arr).forEach(x -> System.out.println(x + " "));
	}
	
	
	public void sort(int[] array, int low, int high) {
		if(low < high) {
			int p = partition(array, low, high);
			sort(array, low, p-1);
			sort(array, p+1, high);
		}		
	}
	
	public int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		
		for(int j = low ; j <= high-1 ; j++) {
			if (arr[j] < pivot) {
				swap(arr, low, j);
				low++;
			}
		}
		swap(arr, low, high);
		return (low);
	}
	
	public void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
