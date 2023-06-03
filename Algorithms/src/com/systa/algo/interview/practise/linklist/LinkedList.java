/**
 * 
 */
package com.systa.algo.interview.practise.linklist;

/**
 * @author mohsin
 *
 */
public class LinkedList {
	
	private Node firstNode = null;
	private int index = 0;

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.createLinkedList("firstNode");
		list.insertNewNode("secondNode");
		list.insertNewNode("thirdNode");
		list.insertNewNode("FourthNode");
		list.printLinkedList();
		
	}
	
	public void createLinkedList(String value) {
		this.firstNode = new Node(value);
		this.index++;
	}
	
	public void insertNewNode(String value) {
		Node node = this.getNodeAtIndex(this.index);
		Node nodeToAdd = new Node(value);
		node.setNextNode(nodeToAdd);
		this.index++;
	}
	
	public Node getNodeAtIndex(int index) {
		Node node = firstNode;
		int i = 1;
		if(index > this.index) {
			return null;
		}
		if(node.getNextNode() == null) {
			return node;
		}
		while(i < index) {
			node = node.getNextNode();
			i++;
		}
		return node;
	}
	
	public void printLinkedList() {
		Node node = this.firstNode;
		while(node != null) {
			System.out.print(node.getValue() + " --> ");
			node = node.getNextNode();
		}
	}

}
