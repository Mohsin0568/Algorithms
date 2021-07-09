package problem.solving.searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 4));
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(7, 10));
		intervals.add(new Interval(9, 11));
		intervals.add(new Interval(11, 13));
		intervals.add(new Interval(6, 9));
		addAndMergeIntervals(intervals);
		
//		System.out.println(intervals);
	}
	
	public static void addAndMergeIntervals(List<Interval> arr)  
    {  
        Collections.sort(arr);
    
        int index = 0; // Stores index of last element  
        for (int i=1; i<arr.size(); i++)  
        {  
            // If this is not first Interval and overlaps  
            // with the previous one  
            if (arr.get(index).end >=  arr.get(i).start)  
            {  
                   // Merge previous and current Intervals  
            	arr.get(index).end = Math.max(arr.get(index).end, arr.get(i).end);  
            	arr.get(index).start = Math.min(arr.get(index).start, arr.get(i).start);  
            }  
            else { 
            	arr.set(index, arr.get(i));  
                index++; 
            }     
        } 
          
        // Now arr[0..index-1] stores the merged Intervals  
        System.out.print("The Merged Intervals are: "); 
        for (int i = 0; i <= index; i++)  
        { 
            System.out.print("[" + arr.get(i).start + "," 
                                        + arr.get(i).end + "]");  
        } 
    } 

}
