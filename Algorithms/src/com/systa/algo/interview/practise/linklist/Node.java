package com.systa.algo.interview.practise.linklist;


public class Node {

	private Node nextNode;	
	private String value;

	public Node(String value) {
		super();
		this.value = value;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}	
}
