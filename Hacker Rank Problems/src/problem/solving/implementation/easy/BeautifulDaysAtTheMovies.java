package problem.solving.implementation.easy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) {
		System.out.println(beautifulDays(20, 23, 6));

	}
	
	static int beautifulDays(int i, int j, final int k) {

        AtomicInteger totalBeautifulDays = new AtomicInteger(0);
        
        IntStream.rangeClosed(i, j).forEach(x -> {
            
            int reverseNumber = reverseNumber(x);
            
            int diff = Math.abs(reverseNumber - x);
            
            if(diff % k == 0)
                totalBeautifulDays.set(totalBeautifulDays.get() + 1);            
            
        });
        
        return totalBeautifulDays.get();

    }
    
    static int reverseNumber(int n) {
        
        int reverseNumber = 0;
        
        while(n != 0) {
            reverseNumber *= 10;
            reverseNumber += n % 10;
            n = n / 10;
        }
        return reverseNumber;
    }

}
