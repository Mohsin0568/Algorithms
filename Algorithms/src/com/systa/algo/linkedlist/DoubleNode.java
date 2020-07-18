package com.systa.algo.linkedlist;

public class DoubleNode {
	
	private int value;
	private DoubleNode nextNode;
	private DoubleNode previousNode;	

	public DoubleNode(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setNextNode(DoubleNode nextNode){
		this.nextNode = nextNode;
	}
	
	public DoubleNode getNextNode(){
		return this.nextNode;
	}
	
	public DoubleNode getPreviousNode() {
		return previousNode;
	}

	public void setPreviousNode(DoubleNode previousNode) {
		this.previousNode = previousNode;
	}
}
