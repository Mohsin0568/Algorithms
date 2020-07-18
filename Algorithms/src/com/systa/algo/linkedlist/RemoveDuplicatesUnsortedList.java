package com.systa.algo.linkedlist;

public class RemoveDuplicatesUnsortedList {
	
	private Node headNode = null;

	public static void main(String[] args) {		
		RemoveDuplicatesUnsortedList list = new RemoveDuplicatesUnsortedList();
		list.addAtHead(1);
		list.addAtHead(2);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 1);
		list.addAtIndex(4, 4);
		list.addAtIndex(5, 2);
		list.addAtIndex(6, 7);
		list.addAtIndex(7, 6);
		list.addAtIndex(8, 7);
		list.printList();
		list.removeDuplicates(list.getHeadNode());
		list.printList();
	}
	
	public void removeDuplicates(Node node){
		while(node != null && node.getNextNode() != null){
			Node nextNode = node.getNextNode();
			Node prevNode = node;
			while(nextNode != null){
				if(node.getValue() == nextNode.getValue()){
					prevNode.setNextNode(nextNode.getNextNode());
					nextNode = prevNode.getNextNode();					
				}
				else{
					prevNode = nextNode;
					nextNode = nextNode.getNextNode();
				}
			}
			node = node.getNextNode();
		}
	}
	
	public Node getHeadNode(){
		return this.headNode;
	}
	
	public void addAtHead(int val) {
        Node nodeToAdd = new Node(val);
        nodeToAdd.setNextNode(headNode);
        headNode = nodeToAdd;        
    }
	
	public void addAtIndex(int index, int val) {
        
        if(index == 0){
        	addAtHead(val);
        	return;
        }
        
        Node nodeToAdd = new Node(val);
        Node node = headNode;
        int i = 0;
        while(true){
        	if(i == index-1){
        		break;
        	}
        	i++;
        	node = node.getNextNode();
        }
        nodeToAdd.setNextNode(node.getNextNode());
        node.setNextNode(nodeToAdd);
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
