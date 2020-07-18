package problem.solving.implementation.medium;

import java.util.Arrays;
import java.util.List;

public class ClimbingTheLeaderboard {
	
	public static List<Integer> publicScores = null;

	public static void main(String[] args) {
		int[] result = climbingLeaderboard(new int[]{100, 90, 90, 80, 75, 60},
				new int[]{50, 65, 77, 90, 102});
		
		for(int x : result){
			System.out.print(x + " ");
		}

	}
	
	public static int getSum(final int aliceNumber, int[] scores) {
        return (int) Arrays.stream(scores)
                .filter(number -> number > aliceNumber)
                .parallel()
                .count()+1;
    }
	
	static int[] climbingLeaderboard(int[] scores, int[] alice) {

        //publicScores = Arrays.stream(scores).distinct().boxed().collect(Collectors.toList());
        return Arrays.stream(alice).parallel().map( x -> {
        	return getSum(x, scores);
        })            
            .toArray();

    }

}
