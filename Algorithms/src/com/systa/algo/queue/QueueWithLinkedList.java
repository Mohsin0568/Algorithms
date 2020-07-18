package com.systa.algo.queue;

import com.systa.algo.linkedlist.Node;

public class QueueWithLinkedList {
	
	Node head = null;
	Node tail = null;

	public static void main(String[] args) {
		QueueWithLinkedList queue = new QueueWithLinkedList();
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.enQueue(5);
		queue.enQueue(6);
		queue.enQueue(7);
		queue.printQueue();
		queue.front();
		queue.rear();
		System.out.println("-------------------------");
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.deQueue();
		queue.printQueue();
		queue.front();
		queue.rear();
		System.out.println("-------------------------");
		queue.deQueue();
		queue.enQueue(3);
		queue.deQueue();
		queue.printQueue();
		queue.front();
		queue.rear();
	}
	
	private boolean enQueue(int value){ // new node will be added to head.
		Node nodeToAdd = new Node(value);
		if(head == null){
			head = tail = nodeToAdd;
		}
		else{
			tail.setNextNode(nodeToAdd);
			tail = nodeToAdd;
		}
		return true;
	}
	
	private boolean deQueue(){ // value will be popped out from tail
		if(head == null){
			System.out.println("Queue is empty");
			return false;
		}
		
		head = head.getNextNode();
		if(head == null)
			tail = null;
		
		return true;
	}
	
	private void front(){
		if(head == null)
			System.out.println("Queue is empty");
		else
			System.out.println("Front value is " + head.getValue());
	}
	
	private void rear(){
		if(head == null)
			System.out.println("Queue is empty");
		else
			System.out.println("Rear value is " + tail.getValue());
	}
	
	private void printQueue(){
		System.out.print("Elements are: ");
		Node temp = head;
		while(temp != null){
			System.out.print(temp.getValue() + " --> ");
			temp = temp.getNextNode();
		}
		System.out.println();
	}

}
