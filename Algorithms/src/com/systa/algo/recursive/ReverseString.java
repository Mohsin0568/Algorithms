package com.systa.algo.recursive;

public class ReverseString {

	public static void main(String[] args) {
		
		char s[] = new char[]{'h', 'e', 'l', 'l', 'o'};
		reverseString(s);
		System.out.println(s);

	}
	
	public static void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
        
    }
	
	public static void reverse(char[]s, int startLocation, int endLocation){
        
        if(startLocation > endLocation || startLocation == endLocation){
            return;
        }
        
        char temp = s[startLocation];
        s[startLocation] = s[endLocation];
        s[endLocation] = temp;
        
        reverse(s, startLocation+1, endLocation-1);
                   
        
    }

}
