package com.systa.algo.recursive;

public class PrintNumbers {

	public static void main(String[] args) {
		
		PrintNumbers printNumbers = new PrintNumbers();
		printNumbers.printNumberInReverse(10);
	}

	public void printNumberInReverse(int number){
		if(number == 0)
			return;
		else
			printNumberInReverse(number - 1);
		
		System.out.println(number);
	}
}
