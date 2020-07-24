package problem.solving.searching;

import java.util.Arrays;
import java.util.List;

public class SherlockAndArray {

	public static void main(String[] args) {
		System.out.println(balancedSums(Arrays.asList(1, 1, 4, 1, 2)));

	}
	
	
	// this method did'nt pass all the test cases
	static String balancedSums(List<Integer> arr, int k) {
        
        if(arr.size() == 1)
            return "YES";
        
        if(arr.size() == 2)
            return "NO";
        
        for(int i = 1 ; i < arr.size()-1; i++){
        	int leftValue = arr.subList(0, i).stream().reduce(Integer :: sum).get();
            int rightValue = arr.subList(i+1, arr.size()).stream().reduce(Integer :: sum).get(); 
            if( leftValue == rightValue ){
                return "YES";                
            }
        }
        
        return "NO";
    }
	
	static String balancedSums(List<Integer> arr) {
        
        if(arr.size() == 1)
            return "YES";
        
        if(arr.size() == 2)
            return "NO";
        
        int total = arr.stream().reduce(Integer :: sum).get();
        total -= arr.get(0);
        int frontSum = 0;
        
        for(int i = 1; i < arr.size()-1; i++){
        	frontSum += arr.get(i-1);
        	total -= arr.get(i);
        	
        	if(frontSum == total)
        		return "YES";
        }
        
        
        
        return "NO";
    }

}
