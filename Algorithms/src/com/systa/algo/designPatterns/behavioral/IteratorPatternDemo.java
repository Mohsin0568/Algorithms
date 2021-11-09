/**
 * 
 */
package com.systa.algo.designPatterns.behavioral;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mohsin
 * 
 * Iterator pattern allows traversing the elements of an aggregate or a collection sequentially without exposing the underlying implementation.
 *
 */


// lets define our own implementation of iterator interface.
interface Iterator{
	public boolean hasNext();
	public Object next();
}

// This is our implementation of collection which will also return iterator object
class NamesCollection{
	List<String> names;
	
	NamesCollection(){
		names = new ArrayList<>();
	}
	
	public void addName(String name) {
		names.add(name);
	}
	
	public Iterator getIterator() {
		return new NamesCollectionIterator();
	}
	
	private class NamesCollectionIterator implements Iterator{

		int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < names.size() ? true : false;
		}

		@Override
		public Object next() {
			return names.get(i++);
		}		
	}
}

public class IteratorPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NamesCollection names = new NamesCollection();
		names.addName("X");
		names.addName("Y");
		names.addName("Z");
		
		Iterator iterator = names.getIterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
