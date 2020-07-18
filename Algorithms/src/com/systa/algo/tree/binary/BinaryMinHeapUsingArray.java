package com.systa.algo.tree.binary;

import java.util.Arrays;

public class BinaryMinHeapUsingArray {
	
	int[] tree = new int[20];
	int tail = 1;

	public static void main(String[] args) {
		BinaryMinHeapUsingArray mTree = new BinaryMinHeapUsingArray();
		mTree.insertElement(10);
		mTree.insertElement(20);
		mTree.insertElement(30);
		mTree.insertElement(40);
		mTree.insertElement(50);
		mTree.levelOrderTraversal();
		mTree.insertElement(5);
		mTree.insertElement(15);
		mTree.insertElement(25);
		mTree.levelOrderTraversal();
		mTree.deleteElement();
		mTree.levelOrderTraversal();
	}
	
	public void insertElement(int value){
		tree[tail] = value;
		heapifyBottomToTop(tail);
		tail++;		
	}
	
	public void deleteElement(){ // in binary min heap, only root can be deleted
		tail--;
		tree[1] = tree[tail];
		tree[tail] = 0;		
		heapifyTopToBottom(1);
	}
	
	public void heapifyTopToBottom(int index){
		if(index >= tail || (tree[index*2] == 0 && tree[(index*2)+1] ==0))
			return;
		
		if(tree[index*2] != 0 && tree[(index*2)+1] != 0 && 
				(tree[index] > tree[index*2] || tree[index] > tree[(index*2)+1])){
			
			if(tree[index*2] < tree[(index*2)+1]){
				int temp = tree[index];
				tree[index] = tree[index*2];
				tree[index*2] = temp;
				heapifyTopToBottom(index*2);
			}
			else{
				int temp = tree[index];
				tree[index] = tree[(index*2)+1];
				tree[(index*2)+1] = temp;
				heapifyTopToBottom((index*2)+1);
			}			
		}
		
		else if(tree[index] > tree[index * 2]){
			int temp = tree[index];
			tree[index] = tree[index*2];
			tree[index*2] = temp;
			heapifyTopToBottom(index*2);
		}
	}
	
	public void heapifyBottomToTop(int index){
		
		if(index <= 1)
			return;
		
		int parent = index / 2;
		if(tree[parent] > tree[index]){
			int temp = tree[parent];
			tree[parent] = tree[index];
			tree[index] = temp;
			heapifyBottomToTop(parent);
		}
		
	}
	
	public void levelOrderTraversal(){
		Arrays.stream(tree).forEach(i -> {
			if(i != 0)
				System.out.print(i + " --> ");
		});
		System.out.println();
	}

}
