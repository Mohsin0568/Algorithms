package problem.solving.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {

	public static void main(String[] args) {
		
		Arrays.stream(closestNumbers(new int[]{5, 4, 3, 2, 1})).forEach(i -> System.out.print(i + " "));

	}
	
	static int[] closestNumbers(int[] arr) {

        List<Integer> pairNumbers = new ArrayList<>();
        
        // sort array
        sort(arr, 0, arr.length-1);
        
        // find pairs with miminum distance
        
        int minValue = Integer.MAX_VALUE;
        
        
        for(int i = 0 ; i < arr.length-1 ; i++) {
            int diff = arr[i+1] - arr[i];
            if(diff < minValue) {
                pairNumbers.clear();
                pairNumbers.add(arr[i]);
                pairNumbers.add(arr[i+1]);
                minValue = diff;
            }
            else if(diff == minValue) {
                pairNumbers.add(arr[i]);
                pairNumbers.add(arr[i+1]);
            }
        }
        
//        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
//        System.out.println(pairNumbers);
        
        return pairNumbers.stream().mapToInt(i -> i).toArray();
    }
    
    // sorting using quick array
    static void sort(int[] arr, int start, int end) {
        if(start > end)
            return;
        
        int pivot = findPivotal(arr, start, end);
        sort(arr, start, pivot-1);
        sort(arr, pivot+1, end);
    }
    
    static int findPivotal(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start-1;
        
        while(start <= end) {
            if(array[start] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[start];
                array[start] = temp;
            }
            start++;
        }
        return i;
    }

}
