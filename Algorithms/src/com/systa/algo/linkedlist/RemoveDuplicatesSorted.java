package com.systa.algo.linkedlist;

public class RemoveDuplicatesSorted {
	
	private Node headNode = null;

	public static void main(String[] args) {		
		RemoveDuplicatesSorted list = new RemoveDuplicatesSorted();
		list.addAtHead(2);
		list.addAtHead(1);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 3);
		list.addAtIndex(4, 3);
		list.addAtIndex(5, 4);
		list.printList();
		list.removeDuplicates(list.getHeadNode());
		list.printList();
	}
	
	public void removeDuplicates(Node node){
		while(node != null){
			if(node.getNextNode() != null && node.getValue() == node.getNextNode().getValue()){
				node.setNextNode(node.getNextNode().getNextNode());
			}
			else{
				node = node.getNextNode();
			}
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
