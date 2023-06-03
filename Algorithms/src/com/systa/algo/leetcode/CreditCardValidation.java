package com.systa.algo.leetcode;

public class CreditCardValidation {

	public static void main(String[] args) {
		String cnumber = "4242424242426742";
	      System.out.println(cnumber + " is " + (isValid(cnumber) ? "valid" : "invalid"));

	}
	
	public static boolean isValid(String cardNumber) {
        
        boolean readSecondDigitSequence = false;
        int sum = 0;

        for(int i = cardNumber.length()-1; i >=0; i--){
            if(readSecondDigitSequence){
                sum = sum + getSingleDigit((Integer.parseInt(cardNumber.charAt(i)+"")) * 2);
                readSecondDigitSequence = !readSecondDigitSequence;
            }
            else{
                sum = sum + Integer.parseInt(cardNumber.charAt(i)+"");
                readSecondDigitSequence = !readSecondDigitSequence;
            }
        }
        
        
        return sum % 10 == 0;
    }

    static int getSingleDigit(int digit){
        if(digit <= 9)
            return digit;
        else
            return (digit / 10) + (digit % 10);
    }
	
	public static boolean validitychk(long cnumber) {
	      return (thesize(cnumber) >= 13 && thesize(cnumber) <= 16) && (prefixmatch(cnumber, 4)
	         || prefixmatch(cnumber, 5) || prefixmatch(cnumber, 37) || prefixmatch(cnumber, 6))
	         && ((sumdoubleeven(cnumber) + sumodd(cnumber)) % 10 == 0);
	   }
	   // Get the result from Step 2
	   public static int sumdoubleeven(long cnumber) {
	      int sum = 0;
	      String num = cnumber + "";
	      for (int i = thesize(cnumber) - 2; i >= 0; i -= 2)
	         sum += getDigit(Integer.parseInt(num.charAt(i) + "") * 2);
	      return sum;
	   }
	   // Return this cnumber if it is a single digit, otherwise,
	   // return the sum of the two digits
	   public static int getDigit(int cnumber) {
	      if (cnumber < 9)
	         return cnumber;
	      return cnumber / 10 + cnumber % 10;
	   }
	   // Return sum of odd-place digits in cnumber
	   public static int sumodd(long cnumber) {
	      int sum = 0;
	      String num = cnumber + "";
	      for (int i = thesize(cnumber) - 1; i >= 0; i -= 2)
	         sum += Integer.parseInt(num.charAt(i) + "");
	      return sum;
	   }
	   // Return true if the digit d is a prefix for cnumber
	   public static boolean prefixmatch(long cnumber, int d) {
	      return getprefx(cnumber, thesize(d)) == d;
	   }
	   // Return the number of digits in d
	   public static int thesize(long d) {
	      String num = d + "";
	      return num.length();
	   }
	   // Return the first k number of digits from
	   // number. If the number of digits in number
	   // is less than k, return number.
	   public static long getprefx(long cnumber, int k) {
	      if (thesize(cnumber) > k) {
	         String num = cnumber + "";
	         return Long.parseLong(num.substring(0, k));
	      }
	      return cnumber;
	   }
}