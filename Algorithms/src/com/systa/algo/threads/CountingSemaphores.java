/**
 * 
 */
package com.systa.algo.threads;

/**
 * @author mohsin
 * 
 * 	Java does provide its own implementation of Semaphore, however, Java's semaphore is initialized with an initial number of permits, rather than the maximum possible permits and the developer is expected to take care of always releasing the intended number of maximum permits.

	Briefly, a semaphore is a construct that allows some threads to access a fixed set of resources in parallel. Always think of a semaphore as having a fixed number of permits to give out. Once all the permits are given out, requesting threads, need to wait for a permit to be returned before proceeding forward.

	Your task is to implement a semaphore which takes in its constructor the maximum number of permits allowed and is also initialized with the same number of permits.
 *
 */
public class CountingSemaphores {
	
	private int maxPermits;
	private int usedPermits = 0;
	
	public CountingSemaphores(int maxPermits) {
		this.maxPermits = maxPermits;
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		CountingSemaphores semaphores = new CountingSemaphores(1);
		Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                    	semaphores.acquire();
                        System.out.println("Ping " + i);
                    }
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                    	semaphores.release();
                        System.out.println("Pong " + i);
                    } catch (InterruptedException ie) {

                    }
                }
            }
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
		
	}

	
	public synchronized void acquire() throws InterruptedException {
		
		while(this.usedPermits == maxPermits ) {
			wait();
		}
		
		this.usedPermits++;
		notify();
	}
	
	public synchronized void release() throws InterruptedException {
		
		while(usedPermits == 0)
			wait();
		
		usedPermits--;
		notify();
	}
}
