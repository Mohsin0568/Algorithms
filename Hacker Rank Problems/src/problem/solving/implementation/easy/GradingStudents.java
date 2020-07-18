package problem.solving.implementation.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GradingStudents {

	
	public static void main(String[] args){
		System.out.println(gradingStudents(Arrays.asList(73, 67, 38, 33)));
	}
	
	public static List<Integer> gradingStudents(List<Integer> grades) {
		
		return grades.stream()
					.map(GradingStudents :: returnRoundOffValue)
					.collect(Collectors.toList());
    }
	
	public static int returnRoundOffValue(int x){
		if(x < 38)
			return x;
		int i = x + 2;
		if(i%5 == 0)
			return i;
		int j = x + 1;
		if(j%5 == 0)
			return j;
		
		return x;
	}
}
