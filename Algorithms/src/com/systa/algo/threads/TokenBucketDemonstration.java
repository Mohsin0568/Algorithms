/**
 * 
 */
package com.systa.algo.threads;

import java.util.HashSet;
import java.util.Set;

/**
 * @author mohsin
 * 
 * Imagine you have a bucket that gets filled with tokens at the rate of 1 token per second. 
 * The bucket can hold a maximum of N tokens. 
 * Implement a thread-safe class that lets threads get a token when one is available. 
 * If no token is available, then the token-requesting threads should block.
 *
 */
public class TokenBucketDemonstration {

	
	public static void main(String[] args) throws InterruptedException {
	
		TokenBucketFilterFactory factory = TokenBucketFilterFactory.getTokenBucketFilterFactoryObject(1);
		Set<Thread> allThreads = new HashSet<Thread>();
		
		for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(new Runnable() {

                public void run() {
                    try {
                    	factory.getToken();
                    } catch (InterruptedException ie) {
                        System.out.println("We have a problem");
                    }
                }
            });
            thread.setName("Thread_" + (i + 1));
            allThreads.add(thread);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
	}
	

}


class TokenBucketFilterFactory{
	
	int maxTokens;
	int token = 0;
	
	private TokenBucketFilterFactory(int capacity) {
		this.maxTokens = capacity;
	}
	
	public static TokenBucketFilterFactory getTokenBucketFilterFactoryObject(int capacity) {
		TokenBucketFilterFactory factory = new TokenBucketFilterFactory(capacity);
		factory.initialize();
		return factory;		
	}
	
	private void initialize() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				demonThread();
			}
			
		});
		
		// setting this thread as daemon, since this thread has infinite while loop and this thread will be killed when main thread exites.
		thread.setDaemon(true);
		thread.start();
	}
	
	// This demon thread will wake up after every second, check the token size is less than capacity, if yes, it increments the token and notifies other threads waiting for token and then again sleep.
	private void demonThread() {
	
		while(true) {
			synchronized(this) {
				
				if(token < maxTokens) {
					token++;
				}
				this.notify();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
	public void getToken() throws InterruptedException {
		synchronized (this) {
			while(token == 0) { // it will check if token is not available then it will go and wait.
				this.wait();
			}
			
			token--;
			
			System.out.println("Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
		}
	}
	
}
