package com.systa.algo.java8;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;

public class LamdbaExamples {
	
	public static void main(String ... args) throws InterruptedException {
		
		// first example of lambda expression, uncomment below statement to run
		//fileFilterImplementation();
		
		// second example of lambda expression, uncomment below statement to run
		//runnableImplementation();		
		
		// third example of lambda expression, uncomment below statement to run
		//comparatorImplementation();
		
		
	}
	
	public static void comparatorImplementation() {
		
		String[] strings = {"****", "*", "***", "**"};
		
		// anonymous class implementation
//		Comparator<String> comparator = new Comparator<String>() {
//			public int compare(String o1, String o2) {
//				return o1.length() - o2.length();
//			};			
//		};
		
		// lamdba expression implementation
		Comparator<String> comparatorLambda = (String o1, String o2) -> o1.length() - o2.length();
		
//		Arrays.sort(strings, comparator);
		Arrays.sort(strings, comparatorLambda);
		for(String s : strings) {
			System.out.println(s);
		}
	}
	
	public static void runnableImplementation() throws InterruptedException {
		
		// anonymous class implementation
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				for(int i = 0 ; i < 3; i++) {
//					System.out.println("Value of i is " + i);
//				}
//				
//			}
//		};
		
		// lamdba expression implementation
		Runnable runnableLambda = () -> {
			for(int i = 0 ; i < 3; i++) {
				System.out.println("Value of i is " + i);
			}
		};
		
//		Thread thread = new Thread(runnable);
		Thread thread = new Thread(runnableLambda);
		thread.start();
		thread.join();
	}
	
	public static void fileFilterImplementation() {
		
		// anonymous class implementation
//		FileFilter filter = new FileFilter() {		
//			@Override
//			public boolean accept(File pathname) {
//				return pathname.getName().endsWith(".java");
//			}
//		};
		
		// lamdba expression implementation
		FileFilter filterLamdba = (File pathname) -> pathname.getName().endsWith(".java");
		
		File currentDir = new File(System.getProperty("user.dir"));
		File file = new File(currentDir.getAbsolutePath());
		File[] files = file.listFiles(filterLamdba);
		for(File f: files) {
			System.out.println(f.getName());
		}
	}

}
