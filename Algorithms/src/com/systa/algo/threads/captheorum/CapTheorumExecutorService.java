package com.systa.algo.threads.captheorum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class CapTheorumExecutorService {

	public static void main(String[] args) {
		
		int[] arr = new int[1000];
		IntStream.rangeClosed(1, 1000).forEach(x -> {
			arr[x-1] = x;
		});
		
		CapTheorumExecutorService service = new CapTheorumExecutorService();
		
		System.out.println(service.performMapReduce(arr));

	}
	
	public long performMapReduce(int[] arr) {
		List<Long> mapData = mapOperation(arr);
		return reduce(mapData);
	}
	
	public long reduce(List<Long> data) {
		return data.stream().mapToLong(x -> x).sum();
	}
	
	public List<Long> mapOperation(int arr[]) {
		List<Long> mapData = new ArrayList<>();
		
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		
		ExecutorCompletionService<Long> service = new ExecutorCompletionService<>(threadPool);
		
		for(int i = 0 ; i < 1000; i+=100) {
			service.submit(getCallableObject(arr, i));
		}
		
		IntStream.range(0, 10).forEach(x -> {
			Future<Long> future = service.poll();
			try {
				mapData.add(future.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		threadPool.shutdown();
		
		return mapData;
		
	}
	
	public long calculateSum(int[] arr) {
		
		return Arrays.stream(arr).sum();		
	}
	
	public Callable<Long> getCallableObject(int[] arr, int i) {
		
		return () -> {
			int[] subArray = new int[100];
			IntStream.rangeClosed(i, i+99).forEach(x -> subArray[x-i] = arr[x]);
			return calculateSum(subArray);
		};
	}

}
