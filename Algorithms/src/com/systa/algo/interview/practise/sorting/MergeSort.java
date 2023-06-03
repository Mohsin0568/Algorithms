package com.systa.algo.interview.practise.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		int[] arr = new int[] {5, 6, 3, 4};
		sort.merge(arr, 0, arr.length);
		Arrays.stream(arr).forEach(System.out :: println);
	}
	
	public void mergeSort(int[] arr, int start, int end, int mid) {
		
	}
	
	public void merge(int[] arr, int start, int end) {
		int mid = (end - start)/2;
		int[] temp1 = new int[mid - start];
		int[] temp2 = new int[end - (mid+1)];
		int lenthOfSortedArray = end - start;
		
		for(int k = start; k < mid ; k++) {
			temp1[k] = arr[k];
		}
		
		for(int k = mid+1; k <= end; k++) {
			temp2[k] = arr[k];
		}
		
		int i=start, j=mid+1;
		for(int k = 0; k < lenthOfSortedArray; k++) {
			if(temp1[i] < temp2[j]) {
				arr[start] = temp1[k];
				start++;
				i++;
			}
			else {
				arr[start] = temp2[k];
				start++;
				j++;
			}
		}
		
		while (i < temp1.length) {
			arr[start] = temp1[i];
			i++;
			start++;
		}
		
		while (j < temp2.length) {
			arr[start] = temp2[j];
			j++;
			start++;
		}
	}

}
