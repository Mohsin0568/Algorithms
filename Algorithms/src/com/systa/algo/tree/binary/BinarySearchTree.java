package com.systa.algo.tree.binary;

public class BinarySearchTree {
	
	Node rootNode;
	
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
		tree.rootNode = tree.insertNode(100, null);
		tree.levelOrderTraversal(tree.rootNode);
		tree.insertNode(50, tree.rootNode);
		tree.insertNode(150, tree.rootNode);
		tree.insertNode(165, tree.rootNode);
		tree.insertNode(75, tree.rootNode);
		tree.levelOrderTraversal(tree.rootNode);
	}
	
	public Node insertNode(int value, Node currentNode){		
		
		if(currentNode == null){
			currentNode = new Node(value);
		}
		
		else if(value > currentNode.getValue()){
			currentNode.setRightChild(insertNode(value, currentNode.getRightChild()));
		}
		
		else
			currentNode.setLeftChild(insertNode(value, currentNode.getLeftChild()));
		
		return currentNode;
	}
	
	public void levelOrderTraversal(Node rootNode){
		Queue queue = new Queue(rootNode);
		while(!queue.isEmpty()){
			Node node = queue.dequeue();
			if(node != null){
				System.out.print(node.getValue() + " --> ");
				queue.enqueue(node.getLeftChild());
				queue.enqueue(node.getRightChild());
			}
		}
		System.out.println();
	}

}
