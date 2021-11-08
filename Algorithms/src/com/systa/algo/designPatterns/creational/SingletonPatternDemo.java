/**
 * 
 */
package com.systa.algo.designPatterns.creational;

/**
 * @author mohsin
 *
 *Singleton Design Pattern
 *
 *	Singleton pattern as the name suggests is used to create one and only instance of a class. There are several examples where only a single instance of a class should exist and the constraint be enforced. Caches, thread pools, registries are examples of objects that should only have a single instance.
 *
 *	Its trivial to new-up an object of a class but how do we ensure that only one object ever gets created? The answer is to make the constructor private of the class we intend to define as singleton. That way, only the members of the class can access the private constructor and no one else.
 *
 *	Formally the Singleton pattern is defined as ensuring that only a single instance of a class exists and a global point of access to it exists.
 */

class ThreadPool{
	
	private static ThreadPool onlyInstance;
	
	private ThreadPool() {
		
	}
	
	static ThreadPool getInstance() {
		if(onlyInstance == null) {
			synchronized (ThreadPool.class) {
				if(onlyInstance == null) {
					onlyInstance = new ThreadPool();
				}
			}
		}
		
		return onlyInstance;
	}
	
	public void doSomething() {
		System.out.println("This application is up and running");
	}
}

public class SingletonPatternDemo {

	public static void main(String args[]) {
		ThreadPool pool = ThreadPool.getInstance();
		pool.doSomething();
	}
}
