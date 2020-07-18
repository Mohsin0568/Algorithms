package problem.solving.implementation.easy;

import java.util.Arrays;

public class BreakingTheRecords {

	public static void main(String[] args) {
		
		int result[] = breakingRecords(new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1});
		Arrays.stream(result).forEach(System.out :: println);

	}
	
	static int[] breakingRecords(int[] scores) {
		
		int max = scores[0], min = scores[0];
		int maxCount = 0, minCount = 0;
		
		for(int i = 1 ; i < scores.length ; i++){
			
			if(scores[i] > max){
				max = scores[i];
				maxCount++;
			}
			else if(scores[i] < min){
				min = scores[i];
				minCount++;
			}
		}
		
		return new int[]{maxCount, minCount};

    }

}
