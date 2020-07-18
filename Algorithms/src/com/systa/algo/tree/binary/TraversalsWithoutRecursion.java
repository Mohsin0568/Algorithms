package com.systa.algo.tree.binary;

public class TraversalsWithoutRecursion {
	
	Node root;

	public static void main(String[] args) {
		TraversalsWithoutRecursion tree = new TraversalsWithoutRecursion();
		tree.insertNode(5);
		tree.insertNode(6);
		tree.insertNode(7);
		tree.insertNode(8);
		tree.insertNode(9);
		tree.insertNode(1);
		tree.insertNode(3);
		tree.insertNode(2);
		tree.preOrderTraversal();
		tree.inOrderTraversal();
		//tree.preOrderTraversal(tree.root);
	}
	
	public void insertNode(int value){
		Node nodeToAdd = new Node(value);
		if(root == null){
			root = nodeToAdd;
			return;
		}
		
		Queue queue = new Queue(root);
		while(!queue.isEmpty()){
			Node n = queue.dequeue();
			if(n.getLeftChild() == null){
				n.setLeftChild(nodeToAdd);
				break;
			}
			else if(n.getRightChild() == null){
				n.setRightChild(nodeToAdd);
				break;
			}
			else{
				queue.enqueue(n.getLeftChild());
				queue.enqueue(n.getRightChild());
			}
		}
	}
	
	public void postOrderTraversla(){
		Node current = root;
		Stack stack = new Stack();
		Stack rootStack = new Stack();
		do{
			if(current.getLeftChild() != null){
				stack.addElementToStack(current);
				current = current.getLeftChild();
			}
			else if(current.getRightChild() != null){
				System.out.print(current.getValue() + " --> ");
				Node node = stack.removeElementFromStack();				
				if(node == null){
					current = null;
				}
				else{
					rootStack.addElementToStack(node);
					current = node.getRightChild();
				}				
			}
			else{
				System.out.print(current.getValue() + " --> ");
				Node n = rootStack.removeElementFromStack();
				if(n != null)
					System.out.print(n.getValue() + " --> ");
				
				
			}
		}while(!stack.isStackEmpty() || current != null);
	}
	
	public void inOrderTraversal(){
		Node current = root;
		Stack stack = new Stack();
		do{
			if(current == null){
				Node n = stack.removeElementFromStack();
				System.out.print(n.getValue() + " --> ");
				current = n.getRightChild();
			}
			 if(current.getLeftChild() != null){
				stack.addElementToStack(current);
				current = current.getLeftChild();
			 }
			 else{
				System.out.print(current.getValue() + " --> ");
				Node n = stack.removeElementFromStack();
				if(n != null){
					System.out.print(n.getValue() + " --> ");
					current = n.getRightChild();
				}
				else
					current = null;
			 }
		}while(!stack.isStackEmpty() || current != null);
		System.out.println();
	}
	
	public void preOrderTraversal(){		
		Node current = root;
		Stack stack = new Stack();
		do{
			if(current == null){
				Node n = stack.removeElementFromStack();
				if(n == null)
					current = null;
				else
					current = n.getRightChild();
				continue;
			}
			System.out.print(current.getValue() + " --> ");
			if(current.getLeftChild() != null){
				stack.addElementToStack(current);
				current = current.getLeftChild();
			}
			else {
				Node n = stack.removeElementFromStack();
				if(n == null)
					current = null;
				else
					current = n.getRightChild();
			}
		}while(!stack.isStackEmpty() || current != null);
		System.out.println();		
	}
	
	public void postOrderTraversal(){
		
	}
	
	public void preOrderTraversal(Node node){
		if(node == null)
			return;
		
		System.out.print(node.getValue() + " --> ");
		preOrderTraversal(node.getLeftChild());		
		preOrderTraversal(node.getRightChild());
	}
}
