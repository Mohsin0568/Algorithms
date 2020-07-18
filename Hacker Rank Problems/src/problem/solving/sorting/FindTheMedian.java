package problem.solving.sorting;

public class FindTheMedian {

	public static void main(String[] args) {
		System.out.println(findMedian(new int[]{0, 1, 2, 4, 6, 5, 3}));

	}

	static int findMedian(int[] arr) {
		
		sort(arr, 0, arr.length-1);
		
		return arr[arr.length/2];

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
