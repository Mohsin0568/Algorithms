package com.systa.algo.stack;

import com.systa.algo.linkedlist.Node;

public class StackWithLinkList {
	
	Node head = null;

	public static void main(String[] args) {
		StackWithLinkList stack = new StackWithLinkList();
		stack.push(6);
		stack.push(9);
		stack.push(10);
		stack.printList();
		System.out.println("--------------");
		stack.pop();
		stack.pop();
		stack.printList();
		stack.top();
		stack.pop();
		stack.printList();
		stack.pop();
	}
	
	public boolean push(int value){
		Node nodeToAdd = new Node(value);
		nodeToAdd.setNextNode(head);
		head = nodeToAdd;
		return true;
	}
	
	public boolean pop(){
		if(head == null){
			System.out.println("Stack is empty");
			return false;
		}
		head = head.getNextNode();
		return true;
	}
	
	public void top(){
		if(head == null)
			System.out.println("Stack is empty");
		else
			System.out.println("Stack top value is " + head.getValue());
	}
	
	public void printList(){
		if(head == null){
			System.out.println("Stack is empty");
			return;
		}
		Node temp = head;
		while(temp != null){
			System.out.print(temp.getValue() + " --> ");
			temp = temp.getNextNode();
		}
		System.out.println();
	}

}
