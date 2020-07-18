package problem.solving.implementation.easy;

public class CircularArrayRotation {

	public static void main(String[] args) {
		circularArrayRotation(new int[]{1, 2, 3}, 10, new int[]{0, 2});

	}
	
	static int[] circularArrayRotation(int[] a, int k, int[] queries) {

		int[] result = new int[queries.length];
		int[] parsedArray = new int[a.length];
		
		if(k % a.length == 0)
			parsedArray = a;
		else{
			int diff = k;		
			
			if(k > a.length){
				while (diff > a.length){			
					diff = diff - a.length;
					
				}
			}
			
			for(int i = diff, j = 0; j < a.length; j++){
				parsedArray[i] = a[j];
				if(i == a.length - 1)
					i = 0;
				else
					i++;
			}
		}
		
		for(int i = 0 ; i < queries.length; i++){
			result[i] = parsedArray[queries[i]];
		}
		
		return result;

    }

}
