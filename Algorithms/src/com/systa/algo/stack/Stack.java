package com.systa.algo.stack;

import java.util.ArrayList;

public class Stack {
	
	private ArrayList<Integer> stack = new ArrayList<>();
	int top = -1;

	public static void main(String[] args) {
		Stack list = new Stack();
		list.push(3);
		list.push(4);
		list.push(6);
		list.pop();
		list.pop();
		list.pop();
		list.top();
		list.printList();
		System.out.println("----------------");
		list.pop();
		list.printList();
		

	}
	
	public boolean push(int value){
		stack.add(value);
		top++;
		return true;
	}
	
	public boolean pop(){
		if(top < 0){
			System.out.println("stack is empty");
			return false;
		}
		
		int value = stack.get(top);
		System.out.println("Value removed " + value);
		stack.remove(top);
		top--;		
		return true;
	}
	
	public void top(){
		if(top < 0)
			System.out.println("stack is empty");
		else
			System.out.println("Top value is " + stack.get(top));
	}
	
	public void printList(){
		System.out.println("Size of stack is " + (top+1));
		stack.stream().forEach(x -> System.out.print(x + "--> "));
		System.out.println();
	}

}
