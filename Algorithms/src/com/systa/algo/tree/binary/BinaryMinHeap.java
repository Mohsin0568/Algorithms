package com.systa.algo.tree.binary;

public class BinaryMinHeap {
	
	Node rootNode;
	
	public static void main(String[] args) {
		BinaryMinHeap tree = new BinaryMinHeap();
		tree.insertNode(10);
		tree.insertNode(20);
		tree.insertNode(30);
		tree.insertNode(15);
		tree.insertNode(25);
		tree.insertNode(5);
		tree.levelOrderTraversal(tree.rootNode);
		tree.deleteNode();
		tree.levelOrderTraversal(tree.rootNode);
	}
	
	private void insertNode(int value){
		Node n = new Node(value);
		if(rootNode == null)
			rootNode = n;
		
		else{
			Queue queue = new Queue(rootNode);
			while(!queue.isEmpty()){
				Node node = queue.dequeue();
				if(node.getLeftChild() == null || node.getRightChild() == null){
					if(node.getLeftChild() == null){
						node.setLeftChild(n);						
					}
					else if(node.getRightChild() == null){
						node.setRightChild(n);
					}
					n.setParentNode(node);
					break;
				}
				queue.enqueue(node.getLeftChild());
				queue.enqueue(node.getRightChild());
			}
			heapifyBottomToTop(n);
		}
	}
	
	public void deleteNode(){ // only root node can be deleted in heap binary tree.
		Node tailNode = getTailNode(); // get tail node to replace it with root node;
		if(tailNode.getParentNode().getRightChild() != null)
			tailNode.getParentNode().setRightChild(null);
		else
			tailNode.getParentNode().setLeftChild(null);
		
		rootNode.setValue(tailNode.getValue()); // replace root node value with tail node.
		heapifyTopToBottom(rootNode);
	}
	
	public void heapifyBottomToTop(Node node){ // this function makes sure the min heap is maintained after new node is added.
		if(node == null || node.getParentNode() == null || node.getValue() > node.getParentNode().getValue())
			return;
		
		int temp = node.getValue();
		node.setValue(node.getParentNode().getValue());
		node.getParentNode().setValue(temp);
		heapifyBottomToTop(node.getParentNode());
		
	}
	
	public void heapifyTopToBottom(Node node){
		if(node == null || (node.getLeftChild() == null && node.getRightChild() == null))
			return;
		
		// if node value is greater than child nodes, then find the smallest values in child nodes and replace it with node value.
		
		if(node.getLeftChild() != null && node.getRightChild() != null && (node.getValue() > node.getLeftChild().getValue() || node.getValue() > node.getRightChild().getValue())){
			if(node.getLeftChild().getValue() < node.getRightChild().getValue()){
				int value = node.getValue();
				node.setValue(node.getLeftChild().getValue());
				node.getLeftChild().setValue(value);
				heapifyTopToBottom(node.getLeftChild());
			}
			else{
				int value = node.getValue();
				node.setValue(node.getRightChild().getValue());
				node.getRightChild().setValue(value);
				heapifyTopToBottom(node.getRightChild());
			}
		}
		
		else if(node.getLeftChild().getValue() < node.getValue()){
			int value = node.getValue();
			node.setValue(node.getLeftChild().getValue());
			node.getLeftChild().setValue(value);
			heapifyTopToBottom(node.getLeftChild());			
		}
	}
	
	private void levelOrderTraversal(Node rootNode){
		Queue queue = new Queue(rootNode);
		while(!queue.isEmpty()){
			Node node = queue.dequeue();
			if(node != null){
				System.out.print(node.getValue() + " --> ");
				if(node.getLeftChild() != null)
					queue.enqueue(node.getLeftChild());
				if(node.getRightChild() != null)
					queue.enqueue(node.getRightChild());
			}
		}
		
		System.out.println();
	}
	
	public Node getTailNode(){
		Queue queue = new Queue(rootNode);
		Node tailNode = null;
		while(!queue.isEmpty()){
			tailNode = queue.dequeue();
			if(tailNode != null){
				if(tailNode.getLeftChild() != null)
					queue.enqueue(tailNode.getLeftChild());
				if(tailNode.getRightChild() != null)
					queue.enqueue(tailNode.getRightChild());
			}
		}
		return tailNode;
	}

}
