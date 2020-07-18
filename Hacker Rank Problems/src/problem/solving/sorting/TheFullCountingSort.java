package problem.solving.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TheFullCountingSort {
	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        StringBuilder[] sb = new StringBuilder[100];
        AtomicInteger k = new AtomicInteger(1);

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
            		String[] input = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            		int index = Integer.parseInt(input[0]);
            		StringBuilder sb1 = sb[index];
            		if(sb1 == null){
            			sb1 = new StringBuilder("");
            			sb[index] = sb1;
            		}
            		
            		if(k.getAndIncrement() <= n/2)
            			sb1.append("- ");
            		else
            			sb1.append(input[1] + " ");
            		
            		
                
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        
        Arrays.stream(sb).forEach(x -> {
			if(x != null)
				System.out.print(x.toString());
		});

        //countSort(arr);

        bufferedReader.close();
    }

	public static void main1(String[] args) {
		List<String> l1 = new ArrayList<>();
		l1.add("0"); l1.add("ab");
		
		List<String> l2 = new ArrayList<>();
		l2.add("6"); l2.add("cd");		
		
		List<String> l3 = new ArrayList<>();
		l3.add("0"); l3.add("ef");		
		
		List<String> l4 = new ArrayList<>();
		l4.add("6"); l4.add("gh");		
		
		List<String> l5 = new ArrayList<>();
		l5.add("4"); l5.add("ij");		
		
		List<String> l6 = new ArrayList<>();
		l6.add("0"); l6.add("ab");
		
		List<String> l7 = new ArrayList<>();
		l7.add("6"); l7.add("cd");
		
		List<String> l8 = new ArrayList<>();
		l8.add("0"); l8.add("ef");
		
		List<String> l9 = new ArrayList<>();
		l9.add("6"); l9.add("gh");
		
		List<String> l10 = new ArrayList<>();
		l10.add("0"); l10.add("ij");
		
		List<String> l11 = new ArrayList<>();
		l11.add("4"); l11.add("that");
		
		List<String> l12 = new ArrayList<>();
		l12.add("3"); l12.add("be");
		
		List<String> l13 = new ArrayList<>();
		l13.add("0"); l13.add("to");
		
		List<String> l14 = new ArrayList<>();
		l14.add("1"); l14.add("be");
		
		List<String> l15 = new ArrayList<>();
		l15.add("5"); l15.add("question");
		
		List<String> l16 = new ArrayList<>();
		l16.add("1"); l16.add("or");
		
		List<String> l17 = new ArrayList<>();
		l17.add("2"); l17.add("not");
		
		List<String> l18 = new ArrayList<>();
		l18.add("4"); l18.add("is");
		
		List<String> l19 = new ArrayList<>();
		l19.add("2"); l19.add("to");
		
		List<String> l20 = new ArrayList<>();
		l20.add("4"); l20.add("the");
		
		List<List<String>> arr = new ArrayList<>();
		arr.add(l1);
		arr.add(l2);
		arr.add(l3);
		arr.add(l4);
		arr.add(l5);
		arr.add(l6);
		arr.add(l7);
		arr.add(l8);
		arr.add(l9);
		arr.add(l10);
		arr.add(l11);
		arr.add(l12);
		arr.add(l13);
		arr.add(l14);
		arr.add(l15);
		arr.add(l16);
		arr.add(l17);
		arr.add(l18);
		arr.add(l19);
		arr.add(l20);
		
		countSortWithStreams(arr);

	}
	
	static void countSort(List<List<String>> arr) {
	
		StringBuilder[] sb = new StringBuilder[100];
		int half = arr.size() / 2;
		
		int i = 1;
		for(List<String> x : arr){
			
			int index = Integer.parseInt(x.get(0));
			StringBuilder data = sb[index];
			if(data == null){
				data = new StringBuilder("");
				sb[index] = data;
			}
			if(i <= half)
				data.append("- ");
			else
				data.append(x.get(1) + " ");
			
			i++;
		}

		Arrays.stream(sb).forEach(x -> {
			if(x != null)
				System.out.print(x.toString());
		});
    }
	
	static void countSortWithStreams(List<List<String>> arr) {
		
		StringBuilder[] sb = new StringBuilder[100];
		int half = arr.size() / 2;
		
		AtomicInteger i = new AtomicInteger(1);
		
		arr.stream().forEach(x -> {
			
			int index = Integer.parseInt(x.get(0));
			StringBuilder data = sb[index];
			if(data == null){
				data = new StringBuilder("");
				sb[index] = data;
			}
			if(i.getAndIncrement() <= half)
				data.append("- ");
			else
				data.append(x.get(1) + " ");		
			
		});

		Arrays.stream(sb).forEach(x -> {
			if(x != null)
				System.out.print(x.toString());
		});
    }
}
