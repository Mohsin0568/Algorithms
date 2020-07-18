package problem.solving.implementation.medium;

import java.util.Arrays;

public class MiniMaxSum {

	public static void main(String[] args) {
		
		miniMaxSum(new int[]{256741038, 623958417, 467905213, 714532089, 938071625});

	}
	
	static void miniMaxSum(int[] arr) {

		Arrays.sort(arr);
		
		long sum = Arrays.stream(arr).mapToLong(x -> x).sum();
		
		System.out.print(sum - arr[arr.length-1] + " ");
		System.out.print(sum - arr[0]);

    }

}
