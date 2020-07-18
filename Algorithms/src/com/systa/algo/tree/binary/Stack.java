package com.systa.algo.tree.binary;

public class Stack {

	LinkedListNode head;
	
	public void addElementToStack(Node node){
		LinkedListNode nodeToAdd = new LinkedListNode(node);
		if(head == null)
			head = nodeToAdd;
		else{
			nodeToAdd.setNextNode(head);
			head = nodeToAdd;
		}
	}
	
	public Node removeElementFromStack(){
		if(head == null)
			return null;
		Node toReturn = head.getNode();
		head = head.getNextNode();
		return toReturn;
	}
	
	public boolean isStackEmpty(){
		if(head == null)
			return true;
		else
			return false;
	}
}
