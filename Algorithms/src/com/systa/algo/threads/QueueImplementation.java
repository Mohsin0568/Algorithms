package com.systa.algo.threads;

public class QueueImplementation {
	
	
	public static void main(String args[]) {
		
	}
	
	

}

class CustomQueue{
	
	Semaphore producer;
	Semaphore consumer;
	int[] array;
	int capacity;
	int head = 0;
	int tail = 0;
	
	public CustomQueue(int capacity) {
		this.capacity = capacity;
		array = new int[capacity];
		producer = new Semaphore(capacity, 0);
		consumer = new Semaphore(capacity, capacity);
	}
	
	public synchronized void queue(int number) throws InterruptedException {
		
		producer.acquire();
	}
	
	public synchronized int enqueue() {
		
		return 0;
	}
	
}

class Semaphore{
	
	private int permissions;
	private int permissionsUsed;
	
	Semaphore(int permissions, int permissionsUsed){
		this.permissions = permissions;
		this.permissionsUsed = permissionsUsed;
	}
	
	public synchronized void acquire() throws InterruptedException {
		
		while(permissions == permissionsUsed) {
			wait();
		}
		
		permissionsUsed++;		
	}
	
	public synchronized void release() {
		
		if(permissionsUsed != 0) {
			permissionsUsed--;			
		}
		
		notify();
	}
}
