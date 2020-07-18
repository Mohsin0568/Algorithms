package problem.solving.implementation.easy;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FlatLandSpaceStations {

	public static void main(String[] args) {
		System.out.println(flatlandSpaceStations(5, new int[]{0, 4}));		
		
	}
	
	static int flatlandSpaceStations(int n, int[] c) {
		
		Arrays.sort(c);
        AtomicInteger maxDistance = new AtomicInteger(0);
        AtomicInteger index = new AtomicInteger(0);

        IntStream.range(0, n).forEach(x -> {
            
            int dist = Integer.MAX_VALUE;
            
            for(int i = index.get() ; i < c.length ; i++){
                
                if(x < c[i]){
                    int distance = Math.abs(x - c[i]);
                    if(distance < dist){
                        dist = distance;
                    }                    
                    break;
                }
                
                if(x == c[i]){
                    dist = 0;
                    index.set(i);
                    break;
                }
                
                int distance = Math.abs(x - c[i]);
                if(distance < dist){
                    dist = distance;
                }
                
            }
            
            if(dist > maxDistance.get()){
                maxDistance.set(dist);
            }
            
        });
        
        return maxDistance.get();

    }

}
