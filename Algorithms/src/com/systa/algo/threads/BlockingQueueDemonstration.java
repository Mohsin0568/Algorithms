/**
 * 
 */
package com.systa.algo.threads;

import java.util.stream.IntStream;

/**
 * @author mohsin
 * 
 * A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to add the new item being enqueued. 
 * Similarly, the queue blocks the dequeue caller if there are no items in the queue. 
 * Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread when an item becomes available in the queue.
 *
 */
public class BlockingQueueDemonstration {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> queue = new BlockingQueue<>(5);
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				IntStream.rangeClosed(1, 50).forEach(x -> {
					try {
						queue.enqueue(x);
						System.out.println("enqueued value is " + x);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
				});
				
			}			
		}, "Thread1");
		
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {				
				IntStream.rangeClosed(1, 25).forEach(x -> {					
					try {
						Integer value = queue.dequeue();
						System.out.println("Thread 2 dequeued --> " + value);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				});				
			}			
		}, "Thread2");
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				IntStream.rangeClosed(1, 25).forEach(x -> {					
					try {
						Integer value = queue.dequeue();
						System.out.println("Thread 3 dequeued --> " + value);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}					
				});				
			}			
		}, "Thread3");
		
		thread1.start();
		thread1.sleep(4000);
		thread2.start();		
		thread2.join();
//		here thread3 will only start after thread2 is completed, 
//		since thread2 has join before thread3 starts.
//		here main thread will execute its next statement only after thread2 is completed.
//		output of this program will show that first thread2 completed its iteration upto 25 and then thread3 will start
		thread3.start();
		thread1.join();
		thread3.join();
		
	}
}

class BlockingQueue<T>{
	
	T[] array;
	Object lock = new Object();
	int size = 0;
	int capacity;
	int tail = 0;
	int head = 0;
	
	@SuppressWarnings("unchecked")
	public BlockingQueue(int capacity) {
		array = (T[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public void enqueue(T item) throws InterruptedException {
		
		synchronized (lock) {
		
			while(size == capacity) {
				System.out.println(Thread.currentThread().getName() + " is going to wait");
				lock.wait();
			}
			
			if(tail == capacity)
				tail = 0;
			
			array[tail] = item;
			tail++;
			size++;
			lock.notifyAll();
		}
	}
	
	public T dequeue() throws InterruptedException {
		
		T item = null;
		synchronized (lock) {
			
			while(size == 0) {
				System.out.println(Thread.currentThread().getName() + " is going to wait");
				lock.wait();
			}
			
			if(head == capacity)
				head = 0;
			
			item = array[head];
			head++;
			size--;
			lock.notifyAll();			
		}
		return item;
	}
}
