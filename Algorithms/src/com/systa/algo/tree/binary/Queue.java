package com.systa.algo.tree.binary;

public class Queue {

	LinkedListNode head = null;
	LinkedListNode tail = null;
	
	public Queue(Node node){
		LinkedListNode linkedListNode = new LinkedListNode(node);
		head = linkedListNode;
		tail = linkedListNode;		
	}
	
	public boolean enqueue(Node node){
		if(node == null)
			return false;
		
		LinkedListNode linkedListNode = new LinkedListNode(node);
		if(head == null){
			head = linkedListNode;
			tail = linkedListNode;
			return true;
		}		
		tail.setNextNode(linkedListNode);
		tail = linkedListNode;
		return true;
	}
	
	public Node dequeue(){
		if(head == null){
			return null;
		}
		
		Node temp = head.getNode();
		head = head.getNextNode();
		if(head == null)
			tail = null;
		return temp;
	}
	
	public Node peek(){
		if (head == null)
			return null;
		else
			return head.getNode();
	}
	
	public boolean isEmpty(){
		if(head == null)
			return true;
		else
			return false;
	}
}
