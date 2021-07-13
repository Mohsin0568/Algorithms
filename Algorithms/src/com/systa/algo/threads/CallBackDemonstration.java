/**
 * 
 */
package com.systa.algo.threads;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mohsin
 * 
 * Design and implement a thread-safe class that allows registeration of callback methods that are executed after a user specified time interval in seconds has elapsed.
 *
 */
public class CallBackDemonstration {

	public static void main(String[] args) throws InterruptedException {
	
//		CallBackExecutor.runTestWithTenCallback();
		CallBackExecutor.runLateThenEarlyCallback();
		
	}

}


class CallBackExecutor{
	
	PriorityQueue<CallBack> queue = new PriorityQueue<>(new Comparator<CallBack>() {

		@Override
		public int compare(CallBack o1, CallBack o2) {
			return (int) (o1.executeAt - o2.executeAt);
		}	
		
	});
	
	ReentrantLock lock = new ReentrantLock();
	Condition newCallBackArrived = lock.newCondition(); // consumer thread will wait on this condition variable, this condition variable will signal consumer thread to continue
	
	private long findSleepDuration() {
        long currentTime = System.currentTimeMillis();
        return queue.peek().executeAt - currentTime;
    }
		
	public void registerCallBacks(CallBack callBack) {
		
		lock.lock();
		queue.add(callBack);
		newCallBackArrived.signal(); // awake the consumer thread if it is waiting for new callback to be available.
		lock.unlock();
		
	}
	
	public void start() throws InterruptedException {
		
		long sleepFor = 0;
		
		while(true) {
			lock.lock();
			
			while(queue.size() == 0) { 
				// if queue size is 0, then no callback to execute, put thread in await till new callback is available.
				// keeping this condition in while loop to prevent thread from executing this logic if spurious wake up happens
				newCallBackArrived.await();
			}
			
			while(queue.size() != 0) {
				sleepFor = findSleepDuration();
				
				if(sleepFor < 0) // if sleep time is less than 0, then that callback is overdue, then exit while loop and execute callback.
					break;
				
				newCallBackArrived.await(sleepFor, TimeUnit.MILLISECONDS); // make thread to sleep till the next callback time is specified.
			}
			
			CallBack callBack = queue.poll(); // take 1st callback from queue and execute.
			System.out.println(
                    "Executed at " + System.currentTimeMillis()/1000 + " required at " + callBack.executeAt/1000
                            + ": message:" + callBack.msg);
			
			lock.unlock(); // release the lock.
		}
	}
	
	public static void runTestWithTenCallback() throws InterruptedException {
		CallBackExecutor executor = new CallBackExecutor();
		
		Thread consumer = new Thread(() -> {
			try {
				executor.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		});
		
		consumer.start();
		Thread.sleep(1000);
		
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread(() -> {

				CallBack callback = new CallBack(1, "Hello, this is " + Thread.currentThread().getName());
				executor.registerCallBacks(callback);
				
			});
			
			thread.setName("Thread " + i);
			thread.start();
			thread.join();
			Thread.sleep(1000);
		}
	}
	
	public static void runLateThenEarlyCallback() throws InterruptedException {
		CallBackExecutor executor = new CallBackExecutor();
		Thread consumer = new Thread(() -> {
			try {
				executor.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		});
		
		consumer.start();
		Thread.sleep(1000);
		
		Thread lateThread = new Thread( () -> {
			CallBack callback = new CallBack(8, "Hello, this is late thread"); // This callback will be executed late since it has a time of 8 seconds
			executor.registerCallBacks(callback);
		});
		
		lateThread.start();
		lateThread.join();
		Thread.sleep(1000);
		
		for(int i = 0; i < 10; i++) {
			Thread thread = new Thread (() -> {
				CallBack callback = new CallBack(1, "Hello, this is " + Thread.currentThread().getName());
				executor.registerCallBacks(callback);
			});
			
			thread.setName("Thread " + i);
			thread.start();
			thread.join();
			Thread.sleep(1000);
		}		
	}
}


class CallBack{
	
	long executeAt;
	String msg;
	
	public CallBack(long executeAfter, String msg) {
		this.executeAt = System.currentTimeMillis() + (executeAfter * 1000);
		this.msg = msg;
	}
}