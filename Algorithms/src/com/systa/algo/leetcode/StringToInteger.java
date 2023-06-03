/**
 * 
 */
package com.systa.algo.leetcode;

/**
 * @author mohsin
 *
 */
public class StringToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(myAtoi("-91283472332"));

	}
	
	public static int myAtoi(String s) {
        
		int number = 0;
		s = s.trim();
		
		
		int sign = s.charAt(0) == '-' ? -1 : 1;
		
		if(s.charAt(0) == '+' || s.charAt(0) == '-') {
			s = s.substring(1);
		}		
		
		for(char x : s.toCharArray()) {
			if(!Character.isDigit(x))
				break;
			
			number = number * 10 + (x - '0');
			
			if(sign * number <= Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else if (sign * number >= Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		}
		
		return number;
		
//		for (int i = 0 ; i < s.length(); i++) {
//        	int x = (int) s.charAt(i);
//        	
//        	if(!isFirstCharacterRead) {
//        		if(x == 32 || x == 48) {
//        			continue;
//        		}
//        		if(x == 45) {
//        			isPositive = false;
//        			isFirstCharacterRead = true;
//        			continue;
//        		}
//        		if(x == 43) {
//        			isFirstCharacterRead = true;
//        			continue;
//        		}
//        		if(x < 49 && x > 57) {
//        			break;
//        		}
//        		isFirstCharacterRead = true;
//        	}
//        	
//        	if(x < 49 || x > 57) {
//    			break;
//    		}
//        	
//        	
//        	Integer tempNumber = new Integer(x - 48);
//        	number = (number * 10) + tempNumber;
//        }
	}

}
