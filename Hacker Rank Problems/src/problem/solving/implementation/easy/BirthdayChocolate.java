package problem.solving.implementation.easy;

import java.util.Arrays;
import java.util.List;

public class BirthdayChocolate {

	public static void main(String[] args) {
		System.out.println(birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2));

	}
	
	static int birthday(List<Integer> s, int d, int m) {

        int numberOfWays = 0;        
        for(int i = 0; i < s.size() - (m-1); i++) {
            int total = 0;
            for(int j = 0 ; j < m ; j++) {
                total += s.get(i+j);
            }
            if(total == d)
                numberOfWays++;
        }
        
        return numberOfWays;

    }

}
