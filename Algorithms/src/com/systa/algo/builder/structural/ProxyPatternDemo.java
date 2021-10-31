/**
 * 
 */
package com.systa.algo.builder.structural;

/**
 * @author mohsin
 *
 */

interface ExpensiveObject{
	void process();
}

/*
 * This class should not be accessed directly, it should be protected by a proxy class
 */
class ExpensiveObjectImpl implements ExpensiveObject{
	
	ExpensiveObjectImpl(){
		heavyConfiguration();
	}

	@Override
	public void process() {
		System.out.println("doing heavy processing");
		
	}
	
	private void heavyConfiguration() {
		System.out.println("doing heavy configuration");
	}
	
}

/*
 * This is a proxy class which will be used to access process method of ExpensiveObject implementation
 */
class ExpensiveObjectProxy implements ExpensiveObject{
	
	private static ExpensiveObject expensiveObject;

	@Override
	public void process() {
		if(expensiveObject == null) {
			expensiveObject = new ExpensiveObjectImpl();
		}
		expensiveObject.process();
	}	
}

public class ProxyPatternDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExpensiveObject expensiveObject = new ExpensiveObjectProxy();
		expensiveObject.process();
	}

}
