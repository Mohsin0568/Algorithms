/**
 * 
 */
package com.systa.algo.threads;

/**
 * @author mohsin
 *
 */
public class ThreadLocalDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		UnSafeCounter usc = new UnSafeCounter();
		SafeCounter sc = new SafeCounter();
        Thread[] tasks = new Thread[100];
        
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    usc.increment();
                	sc.increment();
                }
                sc.printCount(); // prints 100 for every thread
                usc.printCount(); // gets increments for every thread.
            });
            tasks[i] = t;
            t.start();
        }

        for (int i = 0; i < 100; i++) {
            tasks[i].join();
        }

//        usc.printCount();
        
        
	}
}


class UnSafeCounter{
	private int count = 0;
	
	public void increment() {
		count++;
	}
	
	public void printCount() {
		System.out.println(count);
	}
}

class SafeCounter{
	ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    void increment() {
        counter.set(counter.get() + 1);
    }
    public void printCount() {
		System.out.println(counter.get());
	}
}