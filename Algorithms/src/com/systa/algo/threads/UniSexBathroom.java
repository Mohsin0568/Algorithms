/**
 * 
 */
package com.systa.algo.threads;

import java.util.concurrent.Semaphore;

/**
 * @author mohsin
 *
 *
 *	A bathroom is being designed for the use of both males and females in an office but requires the following constraints to be maintained:

 *	There cannot be men and women in the bathroom at the same time.
 *	There should never be more than three employees in the bathroom simultaneously.
 */

public class UniSexBathroom {
	
	private static String MALE = "male";
	private static String FEMALE = "female";
	private static String NONE = "none";
	
	Semaphore maxEmployees = new Semaphore(3);
	
	String inUseBy = NONE;
	int employeesInBathroom = 0;
	

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		final UniSexBathroom unisexBathroom = new UniSexBathroom();

        Thread female1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.femaleUseBathroom("Lisa");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male1 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("John");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male2 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Bob");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male3 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Anil");
                } catch (InterruptedException ie) {

                }
            }
        });

        Thread male4 = new Thread(new Runnable() {
            public void run() {
                try {
                    unisexBathroom.maleUseBathroom("Wentao");
                } catch (InterruptedException ie) {

                }
            }
        });

        male1.start();
        male2.start();
        female1.start();
        male3.start();
        male4.start();

        male1.join();
        male2.join();
        male3.join();
        male4.join();
        female1.join();
	}
	
	public void maleUseBathroom(String name) throws InterruptedException {
		synchronized (this) {
			while(inUseBy.equals(FEMALE)) {
				System.out.println(name + " turn, but he has to wait");
				wait();
			}
			
			maxEmployees.acquire(); // Here thread will lock if maximum 3 permits are given out to threads and execution will proceed once any other thread releases this object. This will make sure that maximum of 3 employees are in bathroom
			employeesInBathroom++;
			inUseBy = MALE;
		}
		
		useBathroom(name);
		maxEmployees.release();
		
		synchronized(this) {
			employeesInBathroom--;
			if(employeesInBathroom == 0)
				inUseBy = NONE;
			notifyAll();
		}
		
		
	}
	
	public void femaleUseBathroom(String name) throws InterruptedException {
		synchronized (this) {
			while(inUseBy.equals(MALE)) {
				System.out.println(name + " turn, but she has to wait");
				wait();
			}				
			
			maxEmployees.acquire();
			employeesInBathroom++;
			inUseBy = FEMALE;
		}
		
		useBathroom(name);
		maxEmployees.release();
		
		synchronized(this) {
			employeesInBathroom--;
			if(employeesInBathroom == 0)
				inUseBy = NONE;
			notifyAll();
		}
	}
	
	public void useBathroom(String name) throws InterruptedException {
		System.out.println(name + " entered the bathroom, current employees in bathroom are " + employeesInBathroom);
		Thread.sleep(1000);
		System.out.println(name + " leaving the bathroom ");
	}

}
