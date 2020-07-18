package com.systa.algo.linkedlist;

public class SingleLinkedList {
	
	private int linkedListLenght = 0;
	private Node headNode = null;
	
	public SingleLinkedList(){
		super();
	}
	
	public int get(int index) {
        if(index > this.linkedListLenght-1)
        	return -1;
        
        if(index == 0)
        	return headNode.getValue();
        
        Node node = headNode;
        for(int i = 1 ; i <= index; i++)
        	node = node.getNextNode();
        
        return node.getValue();
    }
	
	public void addAtHead(int val) {
        Node nodeToAdd = new Node(val);
        nodeToAdd.setNextNode(headNode);
        headNode = nodeToAdd;
        linkedListLenght++;
    }
	
	public void addAtTail(int val) {
		Node nodeToAdd = new Node(val);
		if(headNode == null){
			headNode = nodeToAdd;
			linkedListLenght++;
			return;
		}
		
		Node lastNode = headNode;
		while(true){
			if(lastNode.getNextNode() == null){
				break;
			}
			lastNode = lastNode.getNextNode();
		}
		lastNode.setNextNode(nodeToAdd);
		linkedListLenght++;
    }
	
	public void addAtIndex(int index, int val) {
        if(index > linkedListLenght)
        	return;
        
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
		linkedListLenght++;
    }
	
	public void deleteAtIndex(int index) {
		if(index > linkedListLenght-1)
        	return;
		
		if(index == 0){
			headNode = headNode.getNextNode();
			linkedListLenght--;
			return;
		}			
		
		Node node = headNode;		
		int i = 0;
		while(true){
			if(i == index-1){
				break;
			}
			node = node.getNextNode();
			i++;
		}		
		Node nodeToDelete = node.getNextNode();
		node.setNextNode(nodeToDelete.getNextNode());
		linkedListLenght--;
    }
	
	public void printList(){
		Node lastNode = headNode;
		System.out.println("Size is " + this.linkedListLenght);
		while(lastNode != null){			
			System.out.print(lastNode.getValue() + " --> ");			
			lastNode = lastNode.getNextNode();
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		SingleLinkedList lst = new SingleLinkedList();
		lst.addAtIndex(0, 10);		
		lst.printList();
		lst.addAtIndex(0, 20);		
		lst.printList();
	}
	
}
