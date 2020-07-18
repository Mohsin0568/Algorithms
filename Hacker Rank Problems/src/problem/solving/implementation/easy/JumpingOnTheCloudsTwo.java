package problem.solving.implementation.easy;

public class JumpingOnTheCloudsTwo {

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0}));

	}
	
	static int jumpingOnClouds(int[] c) {

		int jumps = 0;
		int i;
		for(i = 0 ; i < c.length-2; i++){
			if(c[i+2] != 1){
				i++;				
			}
			jumps++;
		}
		
		if(i != c.length-1)
			jumps++;
		
		return jumps;

    }

}
