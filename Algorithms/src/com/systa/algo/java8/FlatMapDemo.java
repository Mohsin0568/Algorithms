/**
 * 
 */
package com.systa.algo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author mohsin
 *
 */
public class FlatMapDemo {

	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		List<Integer> list2 = Arrays.asList(2, 4, 6);
		List<Integer> list3 = Arrays.asList(3, 5, 7);
		
		List<List<Integer>> list = Arrays.asList(list1, list2, list3);
		
//		Function<List<?>, Integer> function1 = s -> s.size();
		Function<List<?>, Integer> function1 = List::size;
		
		// FlatMap function
		Function<List<Integer>, Stream<Integer>> function2 = l -> l.stream();
		
		System.out.println("Sizes of elements in list is");
		list.stream().map(function1).forEach(System.out::println);
		
		System.out.println("Elements of list are");
		//list.stream().flatMap(l -> l.stream()).forEach(System.out::println);
		list.stream().flatMap(function2).forEach(System.out::println);
 
	}

}
