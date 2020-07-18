package com.systa.algo.linkedlist;

public class SeggregateEvenOddSameList {
	
	private Node headNode = null;
	private Node tailNode = null;

	public static void main(String[] args) {
		SeggregateEvenOddSameList list = new SeggregateEvenOddSameList();
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
		System.out.println(list.tailNode.getValue());
		list.sepearteOddWithEven();
		list.printList(list.headNode);
	}
	
	public void sepearteOddWithEven(){
		Node pointer = getHeadNode();
		Node previousNode = null;
		int tailNodeValue = tailNode.getValue();
		
		while(pointer != null && pointer.getValue() != tailNodeValue){
			if(pointer.getValue() % 2 != 0){
				Node temp = pointer.getNextNode();
				
				// set odd node at the tail of the list
				pointer.setNextNode(null);
				tailNode.setNextNode(pointer);
				tailNode = pointer;
				
				// now delete the odd node from its original position
				if(previousNode == null)
					headNode = pointer = temp;
				else{
					previousNode.setNextNode(temp);
					pointer = temp;
				}
			}
			else{
				previousNode = pointer;
				pointer = pointer.getNextNode();
			}			
		}
	}
	
	public void addNode(int val) {
        Node nodeToAdd = new Node(val);
        nodeToAdd.setNextNode(headNode);
        if(headNode == null)
        	tailNode = nodeToAdd;
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

}
