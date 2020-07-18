package problem.solving.implementation.easy;

import java.util.HashMap;
import java.util.Map;

public class MinimumDistances {

	public static void main(String[] args) {
		System.out.println(minimumDistances(new int[] {7, 1, 3, 4, 1, 7}));

	}
	
	static int minimumDistances(int[] a) {

		int minimumDistance = Integer.MAX_VALUE;
		Map<Integer, Integer> indices = new HashMap<>();
		
		for(int i = 0 ; i < a.length; i++){
			
			Integer index = indices.get(a[i]);
			if(index != null){		
				int position = i - index;
				if(position < minimumDistance){
					minimumDistance = position;				
				}			
			}
			indices.put(a[i], i);
		}
		
		return minimumDistance != Integer.MAX_VALUE ? minimumDistance : -1;

    }

}
