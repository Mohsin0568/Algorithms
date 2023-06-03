/**
 * 
 */
package com.systa.algo.revision.sorting;

import java.util.Arrays;

/**
 * @author mohsin
 *
 */
public class MergeSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] arr1 = new int[]{2, 5, 7, 9};
		int[] arr2 = new int[]{3, 4, 8, 10, 11};
		//mergeSortedArray(arr1, arr2);
		int[] arr3 = new int[] {3, 7, 5, 4, 9, 8, 2};
		mergeSort(arr3, 0, arr3.length);
		System.out.println("After merge sort");
		printArray(arr3);
	}
	
	public static void mergeSortedArray(int[] arr1, int[] arr2) {
		
		int i = 0, j = 0, c = 0;
		int resultArray[] = new int[arr1.length + arr2.length];
		while (i < arr1.length && j < arr2.length) {
			if(arr1[i] < arr2[j]) {
				resultArray[c] = arr1[i];
				i++;
				c++;
			}
			else {
				resultArray[c] = arr2[j];
				j++;
				c++;
			}
		}
		
		while(i < arr1.length) {
			resultArray[c] = arr1[i];
			c++;
			i++;
		}
		
		while(j < arr2.length) {
			resultArray[c] = arr2[j];
			c++;
			j++;
		}
		
		printArray(resultArray);
	}
	
	public static void printArray(int[] array) {
		Arrays.stream(array).forEach(x -> System.out.print(x + " "));
	}
	
	public static void mergeSort(int[] arrayToSort, int startIndex, int endIndex) {
		if(endIndex > startIndex) {
			int mid = (endIndex + startIndex)/2;
			mergeSort(arrayToSort, startIndex, mid);
			mergeSort(arrayToSort, mid+1, endIndex);
			merge(arrayToSort, startIndex, endIndex, mid);
			
		}
	}

	private static void merge(int[] arrayToSort, int startIndex, int endIndex, int mid) {
		
		int i = 0, j = 0;
		int firstArrayLength = mid - startIndex;
		int secondArrayLength = endIndex - (mid+1);
		
		
		int[] temp1 = new int[firstArrayLength];
		int[] temp2 = new int[secondArrayLength];
		
		for(int k = 0; i < firstArrayLength; i++) {
			temp1[k] = arrayToSort[startIndex+k];
		}
		
		for(int k = 0; i < secondArrayLength; i++) {
			temp2[k] = arrayToSort[mid+1+k];
		}
		
		while(i < firstArrayLength && j < secondArrayLength) {
			if(temp1[i] < temp2[j]) {
				arrayToSort[startIndex] = temp1[i];
				i++;
			}
			else {
				arrayToSort[startIndex] = temp2[j];
				j++;
			}
			startIndex++;
		}
		
		while(startIndex < endIndex && i < firstArrayLength) {
			arrayToSort[startIndex] = temp1[i];
			i++;
			startIndex++;
		}
		
		while(startIndex < endIndex && j < secondArrayLength) {
			arrayToSort[startIndex] = temp2[j];
			j++;
			startIndex++;
		}
		
	}

}
