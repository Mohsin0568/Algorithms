package com.systa.algo.searching;

public class LinearSearch {

	public static void main(String[] args) {
		int[] array = new int[]{8, 4, 1,56, 3, -44, 23, -6, 28, 0};
		search(array, 56);
	}
	
	public static void search(int[] arr, int value){
		
		for(int i = 0 ; i < arr.length; i++){
			if(arr[i] == value){
				System.out.println("Value found at position " + (i+1));
				return;
			}
		}
		System.out.println("Value not found");
	}

}
