package problem.solving.sorting;

import java.math.BigInteger;
import java.util.Arrays;

public class BigSorting {

	public static void main(String[] args) {
		
		String arr[] = new String[]{"31415926535897932384626433832795", "1", "3", "10", "3", "5"};
		bigSorting(arr);
		Arrays.stream(arr).forEach(x -> System.out.println(x));
	}
	
	// will be using quickSort
	static String[] bigSorting(String[] unsorted) {
		sort(unsorted, 0, unsorted.length-1); // quick sort
		//sort(unsorted); comb sort
		return unsorted;	
    }
	
	static void sort(String[] arr){ // comb sort
		
		int step = (int) (arr.length/1.3);
		
		while(step > 0){			
			
			for(int i = 0, k = step; k < arr.length; i++,k++){
				BigInteger value = new BigInteger(arr[i]);
				if(value.compareTo(new BigInteger(arr[k])) > 0){
					String temp = arr[i];
					arr[i] = arr[k];
					arr[k] = temp;
				}
			}
			step = (int) (step / 1.3);			
		}
		
	}
	
	static void sort(String[] arr, int start, int end){ // quick sort
		
		if(start > end)
			return;
		
		int pivot = getPivot(arr, start, end);
		sort(arr, start, pivot-1);
		sort(arr, pivot+1, end);
	}

	static int getPivot(String[] arr, int start, int end){
		
		int i = start-1;
		System.out.println("called");
		
		while(start <= end){
			if(compareTo(arr[start], arr[end]) <= 0){
				i++;
				String temp = arr[i];
				arr[i] = arr[start];
				arr[start] = temp;
			}
			start++;
		}
		return i;
	}
	
	static int compareTo(String str1, String str2){
		if(str1.length() > str2.length())
			return 1;
		
		else if (str1.length() < str2.length())
			return -1;
		
		else{
			for(int i = 0 ; i < str1.length(); i++){
				int value1 = str1.charAt(i);
				int value2 = str2.charAt(i);
				if(value1 > value2)
					return 1;
				else if(value1 < value2)
					return -1;
			}
			return 0;
		}
	}
}
