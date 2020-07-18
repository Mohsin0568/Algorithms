package com.systa.algo.recursive;

public class Factorial {

	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.findFactorial(100));
	}
	
	public int findFactorial(int number){
		if(number < 2){
			return 1;
		}
		else
			return number * findFactorial(number-1);
	}

}
