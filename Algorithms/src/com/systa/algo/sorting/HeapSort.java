package com.systa.algo.sorting;

import java.util.Arrays;

/*
 * HeapSort works like, it creates a binary heap tree with array elements (performs heapify from bottom to top after adding one element in heap binary tree.
 * then it removes one one element from binary heap tree and stores in second array. (performs heapify from top to bottom after deleting one element from heap binary tree.
 * second array will be sorted array.
 */

public class HeapSort {

	public static void main(String[] args) {
		int[] array = new int[]{9, 4, 6, 3, 7, 1, 2, 11, 5};
		sort(array);		
	}
	
	public static void sort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			heapifyBottomToTop(arr, i+1);
		}
		
		System.out.println("Elements after added them in binary heap tree");
		Arrays.stream(arr).forEach( x -> System.out.print(x + " "));
		
		int[] sortedArray = new int[arr.length];
		
		// here we have to remove 1st element of the array, since it will have the smallest element
		int i = 0;
		int size = arr.length;
		while(i < arr.length){
			sortedArray[i] = deleteElementFromHead(arr, size);
			size--;
			i++;
		}
		System.out.println();
		System.out.println("Elements after removed them from binary heap tree: ");
		Arrays.stream(sortedArray).forEach( x -> System.out.print(x + " "));
	}
	
	public static int deleteElementFromHead(int[] arr, int size){
		int valueToDelete = arr[0];
		arr[0] = arr[size-1];
		heapifyTopToBottom(arr, 1, size-1); // if newly added element is less than root element, then heapifyBottomToTop till all root element values are lesser than child elements.
		return valueToDelete;
	}
	
	public static void heapifyBottomToTop(int[] arr, int index){		
		if(index <= 1)
			return;
		
		if(arr[index-1] < arr[(index/2)-1]){
			int tmp = arr[index-1];
			arr[index-1] = arr[(index/2)-1];
			arr[(index/2)-1] = tmp;
		}
		
		heapifyBottomToTop(arr, index/2);
			 
	}
	
	/*
	 * arr[index] --> to access root element
	 * arr[index*2] --> to access left child
	 * arr[(index*2)+1] --> to access right child
	 * Note: doing -1 while accessing root, left child and right child from array, bcoz index is starting from 1 and array starts from 0
	 */
	
	public static void heapifyTopToBottom(int[] arr, int index, int size){
		
		int left = index*2; // left child of the root element
		int right = (index*2)+1; // right child of the root element
		int smallest;
		
		if(left > size) // has no child elements
			return;
		
		if(right > size){ // has only left child
			if(arr[index-1] > arr[left-1]){ // root element is greater than left child, swap root element value with left child element and heapifyTopToBottom with new index
				int tmp = arr[index-1];
				arr[index-1] = arr[left-1];
				arr[left-1] = tmp;
				heapifyTopToBottom(arr, left, size);
			}			
		}
		else if(arr[index-1] > arr[left-1] || arr[index-1] > arr[right-1]){ // root element is either greater than left child or right child
			if(arr[left-1] < arr[right-1]) // left child has the smallest element, swap root element value with left child element and heapifyTopToBottom with new index
				smallest = left; 
			else // right child has the smallest element, swap root element value with right child element and heapifyTopToBottom with new index
				smallest = right;			
				
			int tmp = arr[index-1];
			arr[index-1] = arr[smallest-1];
			arr[smallest-1] = tmp;
			heapifyTopToBottom(arr, smallest, size);			
		}
	}
}
