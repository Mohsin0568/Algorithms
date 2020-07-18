package problem.solving.implementation.easy;

public class DivisibleSumPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static int divisibleSumPairs(int n, int k, int[] ar) {

        int count = 0;

        for(int i = 0; i < n - 1 ; i++) {
            for(int j = i+1; j < n ; j++) {
                
                if((ar[i] + ar[j]) % k == 0){
                    count++;
                }
            }
        }        
        return count;
    }

}
