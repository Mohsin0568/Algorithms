/**
 * 
 */
package com.systa.algo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author mohsin
 *
 */
public class BlockingQueueDemonstrationMutex {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		BlockingQueueMutex<Integer> queue = new BlockingQueueMutex<>(5);
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				IntStream.rangeClosed(1, 50).forEach(x -> {
					queue.enqueue(x);
					System.out.println("enqueued value is " + x);
				});
				
			}			
		});
		
		
		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {				
				IntStream.rangeClosed(1, 25).forEach(x -> {					
					Integer value = queue.dequeue();
					System.out.println("Thread 2 dequeued --> " + value);
										
				});				
			}			
		});
		
		Thread thread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				IntStream.rangeClosed(1, 25).forEach(x -> {					
					Integer value = queue.dequeue();
					System.out.println("Thread 3 dequeued --> " + value);
										
				});				
			}			
		});
		
		thread1.start();
		thread1.sleep(4000);
		thread2.start();		
		thread3.start();		
	}

}

class BlockingQueueMutex<T>{
	
	T[] array;
	Lock lock = new ReentrantLock();
	int size = 0;
	int capacity;
	int head = 0;
	int tail = 0;
	
	@SuppressWarnings("unchecked")
	public BlockingQueueMutex(int capacity) {
		this.capacity = capacity;
		array = (T[]) new Object[capacity]; 
	}
	
	public void enqueue(T item) {
		
		lock.lock();
		while(size == capacity) {
			lock.unlock();
			
			lock.lock();
		}
		
		if(tail == capacity)
			tail = 0;
		
		array[tail] = item;
		tail++;
		size++;
		lock.unlock();
	}
	
	public T dequeue() {
		T item = null;
		lock.lock();
		
		while(size == 0) {
			lock.unlock();
			
			lock.lock();
		}
		
		if(head == capacity)
			head = 0;
		
		item = array[head];
		head++;
		size--;
		lock.unlock();
		
		return item;
	}
}
