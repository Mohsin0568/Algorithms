package com.systa.algo.hashing;

public class Node<T, K> {

	
	private Node nextNode;
	private T key;
	private K value;
	
	public Node getNextNode() {
		return nextNode;
	}
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	public T getKey() {
		return key;
	}
	public void setKey(T key) {
		this.key = key;
	}
	public K getValue() {
		return value;
	}
	public void setValue(K value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [key=" + key + ", value=" + value + "]";
	}
}
