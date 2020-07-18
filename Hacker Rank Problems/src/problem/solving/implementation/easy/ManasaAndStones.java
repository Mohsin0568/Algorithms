package problem.solving.implementation.easy;

import java.util.Set;
import java.util.TreeSet;

public class ManasaAndStones {

	public static void main(String[] args) {
		int[] result = stones(7, 9, 11);
		for(int x : result){
			System.out.print(x + " ");
		}

	}
	
	static int[] stones(int n, int a, int b) {
		
		Set<Integer> result = new TreeSet<Integer>();

		for(int i = 1 ; i < n ; i++){
			
			int sum = 0;
			 
			for(int j = 1 ; j < n ; j++){
				
				if(i == j){
					sum += b;
				}
				else{
					sum += a;
				}
			}
			result.add(sum);
			
		}
		
		for(int i = 1 ; i < n ; i++){
			
			int sum = 0;
			 
			for(int j = 1 ; j < n ; j++){
				
				if(i == j){
					sum += a;
				}
				else{
					sum += b;
				}
			}
			result.add(sum);
			
		}
		
		int sum1 = 0;
		int sum2 = 0;
		for(int i = 1 ; i < n ; i++){
			
			sum1 += a;
			sum2 += b;
			
		}
		
		result.add(sum1);
		result.add(sum2);
		
		return result.stream().mapToInt( i -> i).toArray();

    }

}
