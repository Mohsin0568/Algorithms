package com.systa.algo.linkedlist;

public class ReverseSingleListList {
	
	private Node headNode = null;

	public static void main(String[] args) {
		ReverseSingleListList list = new ReverseSingleListList();
		list.addAtHead(2);
		list.addAtHead(1);
		list.addAtHead(4);
		list.addAtHead(6);
		list.addAtHead(3);
		list.addAtHead(8);
		list.addAtHead(5);
		list.addAtHead(9);
		list.printList();
		list.reverseList();
		list.printList();
	}
	
	public void reverseList(){
		Node pointer = headNode;
		while(pointer.getNextNode() != null){
			Node temp = pointer.getNextNode();
			pointer.setNextNode(pointer.getNextNode().getNextNode());
			temp.setNextNode(headNode);			
			headNode = temp;
		}
	}
	
	public void addAtHead(int val) {
        Node nodeToAdd = new Node(val);
        nodeToAdd.setNextNode(headNode);
        headNode = nodeToAdd;        
    }
	
	public void printList(){
		Node lastNode = headNode;	
		while(lastNode != null){			
			System.out.print(lastNode.getValue() + " --> ");			
			lastNode = lastNode.getNextNode();
		}
		System.out.println();
		
	}

}
