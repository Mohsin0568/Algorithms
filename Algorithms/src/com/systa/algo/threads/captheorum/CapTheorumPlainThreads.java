package com.systa.algo.threads.captheorum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CapTheorumPlainThreads {
	
	private List<Long> mapResults = new ArrayList<>();

	public static void main(String[] args) {
		
		CapTheorumPlainThreads capTheorum = new CapTheorumPlainThreads();
		int[] arr = new int[1000];
		IntStream.rangeClosed(1, 1000).forEach(x -> arr[x-1] = x);
		System.out.println(capTheorum.performMapReduce(arr));
		capTheorum.clearData();
	}
	
	public void clearData() {
		this.mapResults.clear();
	}
	
	public long performMapReduce(int[] arr) {
		mapFunction(arr);
		return reduceFunction();
	}
	
	public int[] createArrayWithRange(int[] arr, int start) {
		int[] result = new int[1000];
		IntStream.rangeClosed(start, start+99).forEach(x -> result[x-start] = arr[x]);
		return result;
	}
	
	public void mapFunction(int[] arr) {
		
		for(int i = 0; i < 1000; i+=100) {
			int[] subArray = createArrayWithRange(arr, i);			
			Thread t = new Thread(() -> this.calculateSum(subArray) );			
			t.start();
		}
		
	}
	
	public long reduceFunction() {
		return mapResults.stream().mapToLong(x -> x).sum();
	}
	
	public void calculateSum(int[] arr) {
		mapResults.add(new Long(Arrays.stream(arr).sum()));
	}

}