package com.systa.algo.interview.practise;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithGivenSum {

	public static void main(String[] args) {
		CountPairsWithGivenSum sum = new CountPairsWithGivenSum();
		sum.printPairsWithGivenSum(new int[] {5, 1, -1, 7, 4, 5}, 6);
		System.out.println("abcd".hashCode());
	}
	
	public void printPairsWithGivenSum(int[] arr, int sum) {
		
		// arr=[5, 1, -1, 7, 5] and sum=6
		Set<Integer> tempSet = new HashSet<>();
		tempSet.add(arr[0]);
		
		for(int i = 1; i < arr.length; i++) {
			int value = sum - arr[i];
			if(tempSet.contains(value)) {
				System.out.println(value + " ," + arr[i]);
			}
			tempSet.add(arr[i]);
		}
	}
}
