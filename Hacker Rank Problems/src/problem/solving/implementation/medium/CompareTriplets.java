package problem.solving.implementation.medium;

import java.util.Arrays;
import java.util.List;

public class CompareTriplets {
	
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        int alice = 0, bob = 0;
        for(int i = 0 ; i < a.size(); i++){
            if(a.get(i) > b.get(i))
            	alice += 1;
            else if(b.get(i) > a.get(i))
                bob += 1;
        }

        return Arrays.asList(alice, bob);

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
