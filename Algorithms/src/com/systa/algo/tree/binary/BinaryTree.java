package com.systa.algo.tree.binary;

public class BinaryTree {

	Node root;
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insertNode(5);
		tree.insertNode(6);
		tree.insertNode(7);
		tree.insertNode(8);
		tree.insertNode(9);
		tree.insertNode(1);
		tree.insertNode(3);
		tree.insertNode(2);
		tree.levelOrderTraversal();
//		tree.isElementPreset(8);
//		tree.isElementPreset(9);
//		tree.isElementPreset(10);
//		tree.isElementPreset(5);
		tree.inOrderTraversal(tree.root);
		System.out.println();
		tree.preOrderTraversal(tree.root);
		System.out.println();
		tree.postOrderTraversal(tree.root);
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
	
	public void isElementPreset(int value){
		Queue queue = new Queue(root);
		while(!queue.isEmpty()){
			Node node = queue.dequeue();
			if(node.getValue() == value){
				System.out.println("Element " + value + " found");
				return;
			}
			
			queue.enqueue(node.getLeftChild());
			queue.enqueue(node.getRightChild());
		}
		System.out.println("Element " + value + " not found");
	}
	
	public void levelOrderTraversal(){
		Queue queue = new Queue(root);
		while(!queue.isEmpty()){
			Node node = queue.dequeue();
			System.out.print(node.getValue() + "--> ");
			queue.enqueue(node.getLeftChild());
			queue.enqueue(node.getRightChild());			
		}
		System.out.println();
	}
	
	public void inOrderTraversal(Node node){
		if(node == null)
			return;
		
		inOrderTraversal(node.getLeftChild());
		System.out.print(node.getValue() + " --> ");
		inOrderTraversal(node.getRightChild());
	}
	
	public void preOrderTraversal(Node node){
		if(node == null)
			return;
		
		System.out.print(node.getValue() + " --> ");
		preOrderTraversal(node.getLeftChild());		
		preOrderTraversal(node.getRightChild());
	}
	
	public void postOrderTraversal(Node node){
		if(node == null)
			return;
		
		postOrderTraversal(node.getLeftChild());
		postOrderTraversal(node.getRightChild());
		System.out.print(node.getValue() + " --> ");
	}

}