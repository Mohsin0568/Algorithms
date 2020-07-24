package problem.solving.searching;

import java.util.Arrays;

public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		//hackerlandRadioTransmitters(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 3);
		//sort(new int[]{7, 2, 4, 6, 5, 9, 12, 11});
		System.out.println(hackerlandRadioTransmitters(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 2));

	}
	
	static int hackerlandRadioTransmitters(int[] arr, int k) {
		arr = Arrays.stream(arr).sorted().toArray();
		int radioToBeInstalled = 0;
		boolean searchStart = true;
		int dist = 0;
		for(int i = 0; i < arr.length; i++){
			if(i == arr.length-1){
				radioToBeInstalled++;
				System.out.println(i);
				break;
			}				
			int p2pdistance = arr[i+1] - arr[i];
			dist += searchStart ? 0 : arr[i] - arr[i-1];
			searchStart = false;
			if((dist + p2pdistance) > k){				
				// install radio on this location
				radioToBeInstalled++;
				System.out.println(i);
				// check after this location for how many location radio signal can be sent
				int sum = 0;
				while(sum <= k && i < arr.length-1){
					sum += arr[i+1] - arr[i];
					i++;
				}
				i--;
				dist = 0;
				searchStart = true;
			}
			
		}
		
		return radioToBeInstalled;

    }
	
	static void sort(int[] arr){
		int arr1[] = Arrays.stream(arr).sorted().toArray();
		Arrays.stream(arr1).forEach(i -> System.out.print(i + " "));
	}

}
