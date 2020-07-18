package problem.solving.implementation.easy;

import java.util.stream.IntStream;

public class ModifiedKaprekarNumbers {

	public static void main(String[] args) {
		kaprekarNumbers(111, 112);

	}
	
	static void kaprekarNumbers(int p, int q) {

        IntStream.rangeClosed(p,  q).forEach( x -> {
            String square = new Long((long)x * (long)x).toString();
            
            if(x == 1)
                System.out.print(x + " ");

            if(square.length() == 1)
                return;
            
            String partTwo = square.substring(square.length()/2);
            String partOne = square.substring(0, square.length()/2);
            
            int result = Integer.parseInt(partOne) + Integer.parseInt(partTwo);
            if(result == x)
                System.out.print(x + " ");
             
        });
        
    }
	
	static int findD(int num){
		
		if(num < 10)
			return 1;
		
		return 1 + findD(num / 10);
		
	}

}
