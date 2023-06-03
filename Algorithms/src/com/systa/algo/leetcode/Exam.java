package com.systa.algo.leetcode;

public class Exam {

	public static void main(String[] args) {
		System.out.println(run("5h",11, 25));
		
		//System.out.println((char) (96+1));

	}
	
	public static String run(String startPosition, int r, int c) {
		
		char[] sps = startPosition.toCharArray();
		
		int rowStart = sps[0] - '0';
		int rendPosition = 0;
		
		while(rowStart > 0) {
			if((8 - rowStart + 1) >= r) {
				rendPosition += rowStart + r;
				break;
			}
			
			r = r - (8 - rowStart + 1);
			rowStart = 1;
		}
		
		int cendPosition = 0;
		int colStart = sps[1] - 96;
		while(colStart > 0) {
			if((8 - colStart) >= c) {
				cendPosition += colStart + c;
				break;
			}
			
			c = c - (8 - colStart + 1);
			colStart = 1;
		}
		
		return rendPosition+""+(char)(96+cendPosition);
	}

}
