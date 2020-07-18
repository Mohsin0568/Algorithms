package problem.solving.implementation.easy;

public class BeautifulTriplets {

	public static void main(String[] args) {
		System.out.println(beautifulTriplets(3, new int[]{1, 2, 4, 5, 7, 8, 10}));

	}
	
	static int beautifulTriplets(int d, int[] arr) {
		
		int triplets = 0;
		
		for (int i = 0 ; i <= arr.length - 3; i++){
			
			for(int j = i + 1 ; j <= arr.length - 2; j++){
				
				if(arr[j] - arr[i] == d){
					
					for(int k = j+1; k < arr.length ; k++){
						
						if(arr[k] - arr[j] == d){
							//System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
							triplets++;
						}
					}
				}		
				
			}			
		}		
		return triplets;

    }

}
