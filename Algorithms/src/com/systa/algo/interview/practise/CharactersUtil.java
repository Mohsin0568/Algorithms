/**
 * 
 */
package com.systa.algo.interview.practise;

/**
 * @author mohsin
 *
 */
public class CharactersUtil {

	public static void main(String[] args) {
		
		CharactersUtil util = new CharactersUtil();
		System.out.println(util.removeRepetativeCharacters("abcddefffggggggh"));

	}
	
	// removing repetitive characters in a string
	public String removeRepetativeCharacters(String str) {
		StringBuilder sb = new StringBuilder("");
		int i = 0;
		char c = ' ';
		while(i < str.length()) {
			char current = str.charAt(i);
			if(current != c) {
				sb.append(current);
				c = current;
			}
			i++;
		}
		return sb.toString();
	}

}
