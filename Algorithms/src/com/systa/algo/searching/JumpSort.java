package com.systa.algo.searching;

public class JumpSort {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 10};
		System.out.println("value found at " + search(array, 10));

	}
	
	public static int search(int arr[], int value){
		int jump = (int) Math.sqrt(arr.length);
		int preValue = 0;
		while(arr[Math.min(jump, arr.length)-1] < value){			
			preValue = jump;
			jump += (int) Math.sqrt(arr.length);			
			if(preValue >= arr.length)
				return -1;
		}
		
		while(arr[preValue] < value){
			preValue++;
			
			if(preValue == Math.min(jump, arr.length))
				return -1;
		}
		
		if(arr[preValue] == value)
			return preValue;
		
		return -1;
	}

}
