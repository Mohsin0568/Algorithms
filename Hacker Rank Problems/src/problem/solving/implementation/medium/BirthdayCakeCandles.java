package problem.solving.implementation.medium;

import java.io.IOException;

public class BirthdayCakeCandles {
	
	static int birthdayCakeCandles(int[] ar) {

		int count = 1, max = 0;
		
		for(int x : ar){
			
			if(x > max){
				max = x;
				count = 1;
			}
			else if (x == max)
				count++;
		}
		
		return count;

    }
	
	public static void main(String[] args) throws IOException {
		System.out.println(birthdayCakeCandles(new int[]{3, 2, 1, 3}));		
        
    }

}
