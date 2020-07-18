package com.systa.algo.linkedlist;

public class ExchangeFirstLastNodeCircular {
	
	private Node headNode = null;

	public static void main(String[] args) {
		ExchangeFirstLastNodeCircular list = new ExchangeFirstLastNodeCircular();
		list.addAtHead(1);
		list.addAtHead(3);
		list.addAtHead(4);
		list.addAtHead(5);
		list.addAtHead(2);
		list.addAtHead(7);
		list.addAtHead(8);
		list.addAtHead(9);
		list.printList();
		list.swapNodes();
		list.printList();
	}
	
	public void swapNodes(){
		Node pointer = headNode;
		Node temp = headNode;
		Node previous = null;
		
		while(pointer.getNextNode() != temp){
			previous = pointer;
			pointer = pointer.getNextNode();			
		}
		
		// swap elements
		headNode = pointer;
		pointer = temp;
		
		// swap pointers
		headNode.setNextNode(temp.getNextNode());
		previous.setNextNode(pointer);
		pointer.setNextNode(headNode);
	}
	
	public void addAtHead(int val) {
        Node n = new Node(val);
        if(headNode == null){
        	headNode = n;
        	headNode.setNextNode(headNode);
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
    }
	
	public void printList(){		
		Node temp = headNode;
		Node lastNode = headNode.getNextNode();
		System.out.print(temp.getValue() + " --> ");
		while(lastNode != temp){			
			System.out.print(lastNode.getValue() + " --> ");			
			lastNode = lastNode.getNextNode();
		}
		System.out.println();
		System.out.println("Circular element is " + lastNode.getValue());
		
	}

}
