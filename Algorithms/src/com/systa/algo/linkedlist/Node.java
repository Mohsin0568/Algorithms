package com.systa.algo.linkedlist;

public class Node {
	
	private int value;
	private Node nextNode;
	
	public Node(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}
	
	public Node getNextNode(){
		return this.nextNode;
	}

}
