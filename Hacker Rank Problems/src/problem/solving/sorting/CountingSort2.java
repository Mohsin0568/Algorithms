package problem.solving.sorting;

import java.util.Arrays;

public class CountingSort2 {

	public static void main(String[] args) {
		int arr[] = new int[]{1, 1, 1, 3, 2, 1};
		countingSort(arr);
		Arrays.stream(arr).forEach( x -> System.out.print(x + " "));
	}
	
	static int[] countingSort(final int[] arr) {

		int[] numberCounts = getNumberCounts(arr);
		int k = 0;
		
		for(int i = 0 ; i < numberCounts.length; i++){
			
			for(int j = 1; j <= numberCounts[i]; j++){
				arr[k] = i;
				k++;
			}
		}
		
		return arr;
    }
	
	static int[] getNumberCounts(int[] arr) {

		int max = Arrays.stream(arr).max().orElse(-1);
		if(max < 1)
			return null;
		
		int[] result = new int[max+1];
		for(int i = 0; i < arr.length; i++){
			result[arr[i]] += 1;
		}
		return result;
    }

}
