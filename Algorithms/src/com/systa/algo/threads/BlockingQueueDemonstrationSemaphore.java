/**
 * 
 */
package com.systa.algo.threads;

/**
 * @author mohsin
 * 
 * A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to add the new item being enqueued. 
 * Similarly, the queue blocks the dequeue caller if there are no items in the queue. 
 * Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread when an item becomes available in the queue.
 *
 */
public class BlockingQueueDemonstrationSemaphore {

	public static void main(String[] args) throws InterruptedException {
		
		final BlockingQueueSemaphore<Integer> q = new BlockingQueueSemaphore<>(5);
		
		Thread t1 = new Thread(new Runnable() {

            public void run() {
                try {
                    for (int i = 0; i < 20; i++) {
                        q.enqueue(new Integer(i));
                        System.out.println("enqueued " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Thread 2 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t3 = new Thread(new Runnable() {

            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println("Thread 3 dequeued: " + q.dequeue());
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        t1.start();
        Thread.sleep(4000);
        t2.start();
        t2.join();

        t3.start();
        t1.join();
        t3.join();
	}

}


class CountingSemaphore{
	
	int usedPermits = 0; // will have count for all used permits
	int maxCount; // max permits allowed, it will be equal to size of the queue.
	
	public CountingSemaphore(int size) {
		this.maxCount = size;
	}
	
	public CountingSemaphore(int size, int initialPermits) {
		this.maxCount = size;
		this.usedPermits = this.maxCount - initialPermits;
	}
	
	public synchronized void acquire() throws InterruptedException {
		
		while(usedPermits == maxCount) {
			wait();
		}
		
		notify();
		usedPermits++;
		
	}
	
	public synchronized void release() throws InterruptedException {
		while(usedPermits == 0)
			wait();
		
		usedPermits--;
		notify();
	}
}

class BlockingQueueSemaphore<T>{
	
	T[] array;
	int size = 0;
	int capacity;
	int head = 0;
	int tail = 0;
	
	CountingSemaphore semProducer;
	CountingSemaphore semConsumer;
	CountingSemaphore semLock = new CountingSemaphore(1,1);
	
	@SuppressWarnings("unchecked")
	public BlockingQueueSemaphore(int capacity) {
		
		this.capacity = capacity;
		array = (T[]) new Object[capacity];
		semProducer = new CountingSemaphore(capacity, capacity); // producer semaphore will have all permits initially since queue is empty.
		semConsumer = new CountingSemaphore(capacity, 0);	// consumer semaphore will not have any permit initially since queue will be empty and consumer will have no element to read.
		
	}
	
	public void enqueue(T item) throws InterruptedException {
		
		semProducer.acquire();
		semLock.acquire();	// this lock will make sure tht only thread thread will execute the logic and will release consumer permit.	
		
		if(tail == capacity)
			tail = 0;
		
		array[tail] = item;
		tail++;
		size++;
		
		semConsumer.release();
		semLock.release();
	}
	
	public T dequeue() throws InterruptedException {
		T item = null;
		
		semConsumer.acquire();
		semLock.acquire(); // this lock will make sure tht only thread thread will execute the logic and will release producer permit.
		
		if(head == capacity)
			head = 0;
		
		item = array[head];
		head++;
		size--;
		
		semProducer.release();
		semLock.release();
		
		return item;
	}
}