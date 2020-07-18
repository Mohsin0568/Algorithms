package problem.solving.recursion;

public class ThePowerSum {

	public static void main(String[] args) {
		System.out.println(powerSum(10, 2, 1));

	}
	
	static int powerSum(int X, int N, int num) {		
		
		int pow = (int) Math.pow(num, N);
		
		
		if(pow > X)
			return 0;
		else if(pow == X)
			return 1;
		
		return powerSum(X, N, num+1) + powerSum(X-pow, N, num+1);
		

    }

}
