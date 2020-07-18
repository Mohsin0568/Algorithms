package com.systa.algo.tree.binary;

import java.util.Arrays;

public class BinaryTreeWithArray {
	
	int[] tree = new int[16];
	int tail = 0;
	
	public static void main(String args[]){
		BinaryTreeWithArray binaryTree = new BinaryTreeWithArray();
		binaryTree.insertElement(1); 
		binaryTree.insertElement(2); 
		binaryTree.insertElement(3); 
		binaryTree.insertElement(4); 
		binaryTree.insertElement(5); 
		binaryTree.insertElement(6); 
		binaryTree.insertElement(7); 
		binaryTree.insertElement(8); 
		binaryTree.insertElement(9); 
		binaryTree.insertElement(10); 
		binaryTree.insertElement(11); 
		binaryTree.levelOrderTraversal();
		binaryTree.inOrderTraversal(1);
		System.out.println();
		binaryTree.preOrderTraversal(1);
		System.out.println();
		binaryTree.postOrderTraversal(1);
	}
	
	public void insertElement(int value){
		tree[++tail] = value;
 	}
	
	public void levelOrderTraversal(){
		System.out.println("Size of binary tree is " + tail);
		Arrays.stream(tree).forEach(x -> {
			if(x != 0) System.out.print(x + " --> ");
		});
		System.out.println();
	}
	
	
	public void inOrderTraversal(int index){
		if(index > tail) 
			return; 
		inOrderTraversal(index * 2); 
		System.out.print(tree[index] + " --> "); 
		inOrderTraversal((index * 2) + 1);
	}

	public void preOrderTraversal(int index){
		if(index > tail) return; 
		System.out.print(tree[index] + " --> ");
		preOrderTraversal(index*2); 
		preOrderTraversal((index*2) + 1);
	}
	
	public void postOrderTraversal(int index){ 
		if(index > tail)
			return;
		
		postOrderTraversal(index*2); 
		postOrderTraversal((index*2) + 1);
		System.out.print(tree[index] + " --> ");
	}
}
