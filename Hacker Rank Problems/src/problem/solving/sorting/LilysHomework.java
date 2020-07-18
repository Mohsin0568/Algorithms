package problem.solving.sorting;

import java.util.Arrays;


// THis solution is incorrect.
public class LilysHomework {

	public static void main(String[] args) {		
		System.out.println(lilysHomework(new int[]{3, 4, 2, 5, 1}));

	}
	
	static int lilysHomework(int[] arr) {
		int noOfSwaps = 0;
		
		for(int i = 0; i < arr.length; i++){
			int min = findMinLocation(arr, i);
			if(min != i){
				noOfSwaps++;
				int temp = arr[min];
				arr[min] = arr[i];
				arr[i] = temp;
			}
		}
		
		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
		System.out.println();
		return noOfSwaps;
    }
	
	static int findMinLocation(int arr[], int start){
		
		int min = start;
		
		for(int i = start; i < arr.length; i++){
			
			if(arr[i] < arr[min]){
				min = i;
			}
		}
		return min;
	}

}
