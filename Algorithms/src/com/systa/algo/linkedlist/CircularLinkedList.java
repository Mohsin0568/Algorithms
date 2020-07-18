package com.systa.algo.linkedlist;

public class CircularLinkedList {
	
	private int linkedListLenght = 0;
	private Node headNode = null;

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.addAtHead(1);
		list.addAtHead(3);
		list.addAtHead(4);
		list.addAtHead(5);
		list.addAtHead(6); // this is circular element
		list.addAtTail(7);
		list.addAtTail(8);
		list.printList();
		
		list.addAtIndex(0, 9); // now this should be head and circular element
		list.addAtIndex(1, 10);
		list.addAtIndex(9, 11);
		list.printList();
		
		list.deleteAtIndex(0); // now element 10 should be head and circular element
		list.deleteAtIndex(8);		
		list.deleteAtIndex(1);
		list.printList();
		
	}	
	
	public CircularLinkedList(){
		super();
	}
	
	public void addAtHead(int val) {
        Node n = new Node(val);
        if(headNode == null){
        	headNode = n;
        	headNode.setNextNode(headNode);
        	linkedListLenght++;
        	return;
        }
        
       Node temp = headNode;       
        // now last element in the link list should point to the new head
        Node pointer = headNode.getNextNode();
        while(pointer.getNextNode() != temp){
        	pointer = pointer.getNextNode();
        }
        n.setNextNode(headNode);
        headNode = n;
        pointer.setNextNode(headNode);
        linkedListLenght++;
    }
	
	public void addAtTail(int val) {
		Node n = new Node(val);
		
		if(headNode == null){
        	headNode = n;
        	headNode.setNextNode(headNode);
        	linkedListLenght++;
        	return;
        }
		
		Node pointer = headNode.getNextNode();
		Node temp = headNode;
		while(pointer.getNextNode() != temp)
			pointer = pointer.getNextNode();
		
		pointer.setNextNode(n);
		n.setNextNode(headNode);
		linkedListLenght++;
    }
	
	public void addAtIndex(int index, int val) {		
        if(index == 0)
        	addAtHead(val);
        else if (index > linkedListLenght) // cannot add if index is greater than list length
        	System.out.println("Cannot add value");
        else if(index == linkedListLenght)
        	addAtTail(val);
        else{
        	Node nodeToAdd = new Node(val);
        	Node pointer = headNode;
        	for(int i = 0 ; i < index-1; i++)
        		pointer = pointer.getNextNode();
        	
        	nodeToAdd.setNextNode(pointer.getNextNode());
        	pointer.setNextNode(nodeToAdd);
        	linkedListLenght++;
        }
    }
	
	public void deleteAtIndex(int index) {
		Node pointer = headNode;
		if(index == 0){ // delete head node and change last element pointer to new head			
			pointer = headNode.getNextNode();
			Node temp = headNode;
			while(pointer.getNextNode() != temp)
				pointer = pointer.getNextNode();
			
			headNode = headNode.getNextNode();
			pointer.setNextNode(headNode);			
		}
		else{ 
			for(int i = 0 ; i < index-1 ; i++)
				pointer = pointer.getNextNode();
			
			pointer.setNextNode(pointer.getNextNode().getNextNode());
		}
		
		linkedListLenght--;
    }
	
	public void printList(){		
		Node temp = headNode;
		Node lastNode = headNode.getNextNode();
		System.out.println("Size is " + this.linkedListLenght);
		System.out.print(temp.getValue() + " --> ");
		while(lastNode != temp){			
			System.out.print(lastNode.getValue() + " --> ");			
			lastNode = lastNode.getNextNode();
		}
		System.out.println();
		System.out.println("Circular element is " + lastNode.getValue());
		
	}
	

}
