package com.systa.algo.linkedlist;

// Segregate even and odd nodes in a Linked List

public class SeggregateEvenOdd {
	
	private Node headNode = null;
	private Node oddNodes = null;

	public static void main(String[] args) {
		SeggregateEvenOdd list = new SeggregateEvenOdd();
		list.addNode(5);
		list.addNode(2);
		list.addNode(4);
		list.addNode(6);
		list.addNode(3);
		list.addNode(8);
		list.addNode(1);
		list.addNode(10);
		list.addNode(11);
		list.addNode(13);
		list.printList(list.headNode);
		list.sepearteOddWithEven();
		list.printList(list.oddNodes);
		list.printList(list.headNode);
	}
	
	public void addNode(int val) {
        Node nodeToAdd = new Node(val);
        nodeToAdd.setNextNode(headNode);
        headNode = nodeToAdd;        
    }
	
	public Node getHeadNode(){
		return this.headNode;
	}
	
	public void printList(Node headNode){
		Node lastNode = headNode;	
		while(lastNode != null){			
			System.out.print(lastNode.getValue() + " --> ");			
			lastNode = lastNode.getNextNode();
		}
		System.out.println();		
	}
	
	public void sepearteOddWithEven(){
		Node pointer = getHeadNode();
		Node oddPointer = null;
		Node previousNode = null;
		while(pointer != null){
			if(pointer.getValue() % 2 != 0){
				Node n = new Node(pointer.getValue());
				if(oddNodes == null){
					oddNodes = n;
					oddPointer = oddNodes;
				}
				else{
					oddPointer.setNextNode(n);
					oddPointer = n;
				}
				if(previousNode != null)
					previousNode.setNextNode(pointer.getNextNode());
				else
					headNode = pointer.getNextNode();					
			}
			else{
				previousNode = pointer;
			}
			pointer = pointer.getNextNode();
		}
	}

}
