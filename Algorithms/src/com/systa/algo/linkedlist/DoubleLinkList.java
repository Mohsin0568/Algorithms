package com.systa.algo.linkedlist;

public class DoubleLinkList {

	DoubleNode head = null;
	DoubleNode tail = null;
	int length = 0;
	
	public static void main(String[] args) {
		DoubleLinkList list = new DoubleLinkList();
		list.addAtHead(1);
		list.addAtHead(2);
		list.addAtHead(3);
		list.addAtTail(4);
//		list.printListFromHead();
//		list.printListFromTail();
		
		list.addAtIndex(2, 5);
		//list.printListFromHead();
		list.addAtIndex(2, 6);
//		list.printListFromHead();
//		list.deleteAtIndex(0);
//		list.printListFromHead();
//		list.printListFromTail();
//		list.deleteAtIndex(4);
//		list.printListFromHead();
//		list.printListFromTail();
//		list.deleteAtIndex(3);
		list.printListFromHead();
		list.printListFromTail();
		
		
	}
	
	
	public void addAtHead(int val){
		DoubleNode nodeToAdd = new DoubleNode(val);
		if(head == null){
			head = nodeToAdd;
			tail = nodeToAdd;			
		}
		else{
			nodeToAdd.setNextNode(head);
			head.setPreviousNode(nodeToAdd);
			head = nodeToAdd;
		}
		length++;
	}
	
	public void addAtTail(int val){
		if(head == null){
			addAtHead(val);
			return;
		}
		DoubleNode nodeToAdd = new DoubleNode(val);
		tail.setNextNode(nodeToAdd);
		nodeToAdd.setPreviousNode(tail);
		tail = nodeToAdd;
		length++;
	}
	
	public void addAtIndex(int index, int val){
		
		if(index == 0)
			addAtHead(val);
		else if(index == length)
			addAtTail(val);
		else{
			int i = 0;
			DoubleNode temp = head;
			while(i < index){
				i++;
				temp = temp.getNextNode();
			}
			
			DoubleNode nodeToAdd = new DoubleNode(val);
			nodeToAdd.setPreviousNode(temp.getPreviousNode());
			temp.getPreviousNode().setNextNode(nodeToAdd);
			nodeToAdd.setNextNode(temp);
			temp.setPreviousNode(nodeToAdd);
			length++;
		}		
	}
	
	public void deleteAtIndex(int index){
		if(index == 0){
			head.getNextNode().setPreviousNode(null);
			head = head.getNextNode();
		}
		else if(index == length-1){
			tail.getPreviousNode().setNextNode(null);
			tail = tail.getPreviousNode();
		}
		else{
			int i = 0;
			DoubleNode temp = head;
			while(i < index){
				i++;
				temp = temp.getNextNode();
			}
			temp.getPreviousNode().setNextNode(temp.getNextNode());
			temp.getNextNode().setPreviousNode(temp.getPreviousNode());
		}
		length--;
	}
	
	public void printListFromHead(){
		DoubleNode node = head;
		System.out.println("Siz of list is " + length + ", printing from head");
		while(node != null){
			System.out.print(node.getValue() + " --> ");
			node = node.getNextNode();
		}
		System.out.println();
	}
	
	public void printListFromTail(){
		DoubleNode node = tail;
		System.out.println("Siz of list is " + length + ", printing from tail");
		while(node != null){
			System.out.print(node.getValue() + " --> ");
			node = node.getPreviousNode();
		}
		System.out.println();
	}
}
