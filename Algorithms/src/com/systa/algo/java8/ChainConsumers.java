/**
 * 
 */
package com.systa.algo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author mohsin
 *
 */
public class ChainConsumers {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two", "three", "four", "five");
		
		List<String> string2 = new ArrayList<>();
		
//		Consumer<String> c1 = s -> System.out.println(s);
		Consumer<String> c1 = System.out :: println;
		
//		Consumer<String> c2 = s -> string2.add(s);
		Consumer<String> c2 = string2 :: add;
		
//		strings.forEach(c1); // will print all elements of strings list
		strings.forEach(c1.andThen(c2)); // will execute Consumer c1 and then it will execute Consumer c2.
		// andThen is a default method defined in Consumer interface
		
		
		System.out.println("Size of second list is " + string2.size());

	}

}
