package com.systa.algo.recursive;

public class FibnocciSeries {

	public static void main(String[] args) throws Exception{
		
		FibnocciSeries fibnocciSeries = new FibnocciSeries();
		//System.out.println("0, 1, " + fibnocciSeries.printSeries(0, 1, 10));
		
		System.out.println(maskString("1234567890", 0, 6, 'x'));
	}
	
	public String printSeries(int a, int b, int limit){
		if(b > limit)
			return "";
		else
			return a + b + ", " + printSeries(b, a+b, limit);
	}
	
	
	private static String maskString(String strText, int start, int end, char maskChar) 
	        throws Exception{
	        
	        if(strText == null || strText.equals(""))
	            return "";
	        
	        if(start < 0)
	            start = 0;
	        
	        if( end > strText.length() )
	            end = strText.length();
	            
	        if(start > end)
	            throw new Exception("End index cannot be greater than start index");
	        
	        int maskLength = end - start;
	        
	        if(maskLength == 0)
	            return strText;
	        
	        StringBuilder sbMaskString = new StringBuilder(maskLength);
	        
	        for(int i = 0; i < maskLength; i++){
	            sbMaskString.append(maskChar);
	        }
	        
	        return strText.substring(0, start) 
	            + sbMaskString.toString() 
	            + strText.substring(start + maskLength);
	    }

}
