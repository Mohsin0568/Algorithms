package com.systa.algo.linkedlist;

// Swap nodes in a linked list without swapping data
public class SwapTwoNodes {

	private Node headNode = null;

	public static void main(String[] args) {		
		SwapTwoNodes list = new SwapTwoNodes();
		list.addAtHead(2);
		list.addAtHead(1);
		list.addAtIndex(2, 3);
		list.addAtIndex(3, 9);
		list.addAtIndex(4, 7);
		list.addAtIndex(5, 4);
		list.addAtIndex(6, 6);
		list.addAtIndex(7, 5);
		list.addAtIndex(8, 8);
		list.printList();
		list.swapNodes(1, 8);
		list.printList();
	}
	
	public void swapNodes(int a, int b){
		
		if(a == b){
			System.out.println("Cannot swapped");
			return;
		}
		
		Node currX = getHeadNode(), prevX = null;
		while(currX != null && currX.getValue() != a){
			prevX = currX;
			currX = currX.getNextNode();
		}
		
		Node currY = getHeadNode(), prevY = null;
		while(currY != null && currY.getValue() != b){
			prevY = currY;
			currY = currY.getNextNode();
		}
		
		if(currX == null || currY == null){
			System.out.println("Cannot swapped");
			return;
		}
		
		if(prevX == null){  // Node with value a is a Head
			this.headNode = currY;
		}
		else{
			prevX.setNextNode(currY);
		}
		
		if(prevY == null){
			this.headNode = currX;
		}
		else{
			prevY.setNextNode(currX);
		}
		
		Node temp = currX.getNextNode();
		currX.setNextNode(currY.getNextNode());
		currY.setNextNode(temp);		
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
