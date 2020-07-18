package com.systa.algo.hashing;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

// will add elements in a node
// CustomHashMap will have a bucket of size 16
// will use a hash function and will mod it to value 16 to accomadate all elements in a 16 bucket array


public class CustomHashMap<T, K> {
	
	Node<T,K>[] array = new Node[16];

	public boolean add(T key, K value){
		addElementToNode(key, value, hash(key));
		return true;
	}
	
	public K get(T key){
		return getElement(key, hash(key));
	}
	
	private int hash(T key){
		String value = (String)key;
		int sumAscii = value.chars().sum();
		return sumAscii % 16;
	}
	
	private K getElement(T key, int index){
		 Node<T,K> n = array[index];
		 while(n != null){
			 if(n.getKey() == key){
				 return n.getValue();
			 }
		 }
		 return null;
	}
	
	private void addElementToNode(T key, K value, int index){
		Node<T, K> nodeToAdd = new Node<>();
		nodeToAdd.setKey(key);
		nodeToAdd.setValue(value);
		Node<T,K> n = array[index];
		if(n == null){
			array[index] = nodeToAdd;
			return;
		}		
		while(n.getNextNode() != null){
			n = n.getNextNode();
		}		
		n.setNextNode(nodeToAdd);
	}
	
	@Override
	public String toString() {
		AtomicReference<String> returnValue = new AtomicReference<>();
		Arrays.stream(array).forEach(x -> {
			if(x != null){
				while(x != null){
					returnValue.set(returnValue.get() + "[" + x.getKey() + " = " + x.getValue() + "], ");
					x = x.getNextNode();
				}
			}
		});
		return returnValue.get();
	}

	public static void main(String args[]){
		CustomHashMap<String, String> map = new CustomHashMap<>();		
		map.add("Anderson", "London");
		map.add("James", "England");
		System.out.println(map.get("James"));
		System.out.println(map);
	}
	
}