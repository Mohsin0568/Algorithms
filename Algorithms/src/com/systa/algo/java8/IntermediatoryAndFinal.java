/**
 * 
 */
package com.systa.algo.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author mohsin
 *
 */
public class IntermediatoryAndFinal {

	public static void main(String[] args) {
	
		Stream<String> stream = Stream.of("One", "Two", "Three", "Four", "Five");
		
		Predicate<String> p1 = Predicate.isEqual("Two");
		Predicate<String> p2 = Predicate.isEqual("Three");
		
		List<String> list = new ArrayList<>();
		
		// nothing will be printed with below statement, since we have not called terminator function
		Stream<String> stream2 = stream
			.peek(System.out::println)
			.filter(p1.or(p2))
			.peek(list::add);
		
		System.out.println("List size after executing only intermediatory operations " + list.size());
		
		stream2
			.forEach(System.out :: println );
		
		System.out.println("List size after executing terminary operation " + list.size());
		
	}

}
