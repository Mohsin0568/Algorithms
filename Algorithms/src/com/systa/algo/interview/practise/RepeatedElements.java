/**
 * 
 */
package com.systa.algo.interview.practise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mohsin
 * 
 * Removing repeated elements from an array
 *
 */
public class RepeatedElements {
	
	private Set<Integer> elements = new HashSet<>();
	
	

	public static void main(String[] args) {
		int[] elements = new int[] {1, 2, 3, 4, 3, 2, 5, 6, 7, 5, 6};
		RepeatedElements repeatedElements = new RepeatedElements();
		repeatedElements.clearSet();
		repeatedElements.printArray(repeatedElements.removeRepeatedElements(elements));
	}
	
	public void clearSet() {
		this.elements.clear();
	}
	
	public void printArray(int[] elements) {
		Arrays.stream(elements).forEach(System.out :: println);
	}
	
	public int[] removeRepeatedElements(int[] elements) {
		return Arrays.stream(elements)
						.filter(this :: isElementAlreadyPresent)
						.peek(this :: addElement)
						.toArray();
	}
	
	public boolean isElementAlreadyPresent(int element) {
		return !this.elements.contains(element);
	}
	
	public void addElement(int element) {
		this.elements.add(element);
	}

}
