package problem.solving.implementation.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class NonDivisibleSubset {

	public static void main(String[] args) {
		System.out.println(nonDivisibleSubset(5, Arrays.asList(770528134, 663501748, 384261537, 800309024, 103668401, 538539662, 385488901, 101262949, 557792122, 46058493)));

	}
	
	public static int nonDivisibleSubset(int k, List<Integer> s) {
    
		int[] numbers = s.stream().mapToInt(i -> i).toArray();
		Map<Integer, Set<Integer>> subsets = new HashMap<>();
		int subSetSize = 0;
		
		for(int i = 0 ; i < numbers.length ; i++){
			
			int size = insertIntoSubset(subsets, numbers[i], k);
			if(size > subSetSize)
				subSetSize = size;
			
//			for(int j = i+1 ; j < numbers.length; j++){
//				
//				if((numbers[i] + numbers[j]) % k != 0){
//					int size = insertIntoSubset(subsets, numbers[i], numbers[j]);
//					if(size > subSetSize)
//						subSetSize = size;
//				}
//			}
		}
		
		//System.out.println(subset);
		
		return subSetSize;
    }
	
	static int insertIntoSubset(Map<Integer, Set<Integer>> subset, final int i, final int k){
		
		AtomicInteger sizeOfSubset = new AtomicInteger(0);
		
		if(subset.size() == 0){
			Set<Integer> set = new TreeSet<>();
			set.add(i);
			subset.put(1, set);
			return 1;
		}
		else{
			AtomicBoolean addedToSubset = new AtomicBoolean(false);
			subset.entrySet().stream().forEach(x -> {
				Set<Integer> toCheck = x.getValue();
				AtomicBoolean addFlag = new AtomicBoolean(true);
				toCheck.stream().forEach( y -> {
					if((y + i) % k == 0){
						addFlag.set(false);
						return;
					}
				});
				
				if(addFlag.get()){
					toCheck.add(i);
					addedToSubset.set(true);
				}
				
				if(toCheck.size() > sizeOfSubset.get()){
					sizeOfSubset.set(toCheck.size());
				}
				
			});
			
			if(! addedToSubset.get()){
				Set<Integer> set = new TreeSet<>();
				set.add(i);
				subset.put(subset.size() + 1, set);
			}
		}
		
		return sizeOfSubset.get();
		
	}

}
