package com.systa.algo.tree.binary;

public class LinkedListNode {
	
	private Node node;
	private LinkedListNode nextNode;
	
	public LinkedListNode(Node node){
		this.node = node;
	}
	
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	public LinkedListNode getNextNode() {
		return nextNode;
	}
	public void setNextNode(LinkedListNode nextNode) {
		this.nextNode = nextNode;
	}

}
