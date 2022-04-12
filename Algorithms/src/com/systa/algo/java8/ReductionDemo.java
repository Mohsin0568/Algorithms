/**
 * 
 */
package com.systa.algo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author mohsin
 *
 */
public class ReductionDemo {

	public static void main(String[] args) {
		
		List<Integer> values = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		
		System.out.println(values.stream().reduce(0, (s1, s2) -> s1+s2));
		
		BinaryOperator<Integer> operator = (s1, s2) -> s1 + s2;
		
		System.out.println(values.stream().reduce(0, operator));
		
		BinaryOperator<Integer> operator1 = Integer :: sum;
		
		System.out.println(values.stream().reduce(0, operator1));
		
		// Find max value
		
		BinaryOperator<Integer> operator2 = Integer :: max;
		System.out.println("Max value is " + values.stream().reduce(operator2)); // it returns optional value, since there is no identity in reduce arguments
		
	
	}

}
