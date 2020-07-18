package com.systa.algo.queue;

public class CircularQueue {
	
	int queue[] = null;
	int size;
	int head, tail;
	
	CircularQueue(int size){
		queue = new int[size];
		size = 0;
		head = -1;
		tail = -1;
	}
	
	private boolean enQueue(int value){
		if(size == queue.length){
			return false;
		}
		if(head == -1 && tail == -1){
			queue[0] = value;
			head++;
			tail++;
		}
		else{
			tail++;
			tail = tail%queue.length;
			queue[tail] = value;
		}
		size++;
		return true;
	}
	
	private boolean deQueue(){
		if(head == -1){
			return false;
		}
		queue[head] = 0;
		if(head == tail){
			head = -1;
			tail = -1;
		}
		else{
			head = (head+1) % 5;
		}
		size--;
		return true;
	}
	
	private void front(){
		if(head != -1)
			System.out.println("Front value is " + queue[head]);
		else
			System.out.println("Front value is " + -1);
	}
	
	private void rear(){
		if(tail != -1)
			System.out.println("Tail value is " + queue[tail]);
		else
			System.out.println("Tail value is " + -1);
	}
	
	private void printQueue(){
		System.out.print("Elements are: ");
		for(int x : queue)
			System.out.print(x + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue(5);
		circularQueue.enQueue(2);
		circularQueue.enQueue(3);
		circularQueue.enQueue(4);
		circularQueue.enQueue(5);
		circularQueue.enQueue(6);
		circularQueue.enQueue(7);
		circularQueue.printQueue();
		circularQueue.front();
		circularQueue.rear();
		System.out.println("-------------------------");
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.enQueue(7);
		circularQueue.printQueue();
		circularQueue.front();
		circularQueue.rear();
		System.out.println("-------------------------");
		circularQueue.deQueue();
		circularQueue.deQueue();
		circularQueue.printQueue();
		circularQueue.front();
		circularQueue.rear();
	}

}
