package problem.solving.implementation.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EqualizeTheArray {

	public static void main(String[] args) {
		System.out.println(equalizeArray(new int[]{3, 3, 2, 1, 3}));

	}
	
	static int equalizeArray(int[] arr) {
		Map<Integer, Integer> uniqueNumbers = new HashMap<>();
		
		Arrays.stream(arr).forEach(x -> {
			Integer value = uniqueNumbers.get(x);
			if(value == null)
				uniqueNumbers.put(x, 1);
			else
				uniqueNumbers.put(x, value.intValue() + 1);
		});

		AtomicInteger toDelete = new AtomicInteger(Integer.MAX_VALUE);
		
		uniqueNumbers.entrySet().stream().forEach(x -> {
			int value = x.getValue();
			int noOfDeletes = arr.length - value;
			if(noOfDeletes < toDelete.get())
				toDelete.set(noOfDeletes);
		});
		
		return toDelete.get();
    }

}
