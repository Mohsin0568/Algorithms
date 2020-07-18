package problem.solving.implementation.easy;

import java.math.BigInteger;

public class ACMICPCTeam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		acmTeam(new String[]{"10101", "11100", "11010", "00101"});
	}
	
	static int[] acmTeam(String[] topic) {

		int result[] = new int[2];
		
		
		
		for(int i = 0 ; i < topic.length ; i++){
			
			for(int j = i+1 ; j < topic.length ; j++){
				int topics = 0;
				for(int ii = 0 ; ii < topic[i].length(); ii++){
					
					if(topic[i].charAt(ii) == '1' || topic[j].charAt(ii) == '1'){
						topics++;
					}					
				}
				
				if(topics > result[0]){
					result[0] = topics;
					result[1] = 1;
				}
				else if(topics == result[0]){
					result[1] += 1;
				}
				
			}
		}
		
		System.out.println(result[0] + " " + result[1]);
		
		return result;

    }

}
