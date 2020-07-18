package com.systa.algo.searching;

public class BinarySearch {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
		System.out.println("value found at " + search(array, 0, array.length-1, 7));
	}
	
	public static int search(int[] arr, int start, int end, int value){
		
		if(start > end){
			System.out.println("value not found");
			return -1;
		}
		int index = (start+end)/2;
		if(arr[index] == value){
			System.out.println("Value found");
			return index;
		}
		else if(value > arr[index]){
			return search(arr, index+1, end, value);
		}
		else{
			return search(arr, start, index-1, value);
		}
	}

}
