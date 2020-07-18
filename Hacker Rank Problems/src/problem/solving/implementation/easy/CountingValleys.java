package problem.solving.implementation.easy;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class CountingValleys {

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));

	}
	
	static int countingValleys(int n, String s) {
        AtomicInteger position = new AtomicInteger(0); 
        AtomicInteger valleys = new AtomicInteger(0); 

        Stream<Character> charStream = new String(s).chars().mapToObj(i->(char)i);
            
        charStream.forEach( x -> {
                if(x == 'U')
                    position.incrementAndGet();
                else
                    position.decrementAndGet();
                
                if(position.get() == 0 && x == 'U')
                    valleys.incrementAndGet();
        });

        return valleys.get();

    }

}
