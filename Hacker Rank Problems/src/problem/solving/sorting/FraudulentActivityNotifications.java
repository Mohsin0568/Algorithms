package problem.solving.sorting;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FraudulentActivityNotifications {
	
	public static void main(String[] args) {
		System.out.println(activityNotifications(new int[]{2, 3, 4, 2, 3, 6, 8, 4, 5}, 5));
//		int[] arr = new int[]{9, 2, 6, 3, 8, 1, 7};
//		selectionSort(arr, 3);
//		Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
    }
	
	static int activityNotifications(int[] expenditure, int d) {
		
		int mean = d/2;
		boolean isEven = d % 2 == 0;
		int notifications = 0;
		
		for(int i = 0 ; i < expenditure.length; i++){
			
			if(i < d) 
				continue; // till here we don't have expenditure pattern
			
			int meanValue = findMedian(Arrays.copyOfRange(expenditure, i-d, i), mean, isEven);
			if(expenditure[i] >= meanValue)
				notifications++;
		}
		
		return notifications;
    }
	
	static int findMedian(int arr[], int mean, boolean isEven){
		//sort(arr, 0, arr.length-1);
		//countingSort(arr);
		selectionSort(arr, mean);
		if(isEven){
			return (2*(arr[mean] + arr[mean-1]) / 2);
		}
					
		else
			return 2 * arr[mean];
	}
	
	static void selectionSort(int arr[], int mean){
		for(int i = 0; i <= mean; i++){
			for(int j = arr.length-1; j > 0; j--){
				if(arr[j] < arr[j-1]){
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	static void countingSort(int[] arr){
		int[] countingArray = new int[201];
		Arrays.stream(arr).forEach(i -> {
			countingArray[i] += 1;
		});
		
		AtomicInteger j = new AtomicInteger(0);
		AtomicInteger i = new AtomicInteger(0);
		Arrays.stream(countingArray).forEach(k -> {
			if(k > 0){
				IntStream.range(0, k).forEach(z -> arr[j.getAndIncrement()] = i.get());
			}
			i.incrementAndGet();
		});
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

/*
 * HackerLand National Bank has a simple policy for warning clients about possible fraudulent account activity. If the amount spent by a client on a particular day is greater than or equal to  the client's median spending for a trailing number of days, they send the client a notification about potential fraud. The bank doesn't send the client any notifications until they have at least that trailing number of prior days' transaction data.
Given the number of trailing days  and a client's total daily expenditures for a period of  days, find and print the number of times the client will receive a notification over all  days.
For example,  and . On the first three days, they just collect spending data. At day , we have trailing expenditures of . The median is  and the day's expenditure is . Because , there will be a notice. The next day, our trailing expenditures are  and the expenditures are . This is less than so no notice will be sent. Over the period, there was one notice sent.
Note: The median of a list of numbers can be found by arranging all the numbers from smallest to greatest. If there is an odd number of numbers, the middle one is picked. If there is an even number of numbers, median is then defined to be the average of the two middle values.
*/
