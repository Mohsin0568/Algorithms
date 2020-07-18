package com.systa.algo.linkedlist;

public class LinkListLenthRecursive {
	
	private Node headNode = null;

	public static void main(String[] args) {	
		
		LinkListLenthRecursive list = new LinkListLenthRecursive();
		list.addAtHead(2);
		list.addAtHead(1);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 4);
		list.addAtIndex(4, 5);
		list.printList();
		System.out.println(list.length(list.getHeadNode()));
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
	
	public int length(Node head){
		
		if(head == null){
			return 0;
		}
		
		return 1 + this.length(head.getNextNode());
	}

}
