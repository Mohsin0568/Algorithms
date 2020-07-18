package problem.solving.implementation.easy;

public class TaumAndBirthday {

	public static void main(String[] args) {
		System.out.println(taumBday(27984, 1402, 619246, 615589, 247954));

	}

	public static long taumBday(int b, int w, int bc, int wc, int z) {
	    
		if(bc > (wc + z))
			bc = wc + z;
		
		if(wc > (bc + z))
			wc = bc + z;
		
		Long white = (long)(w) * (long)(wc);
		Long black = (long)(b) * (long)(bc);
		
		return new Long(white + black);

	}
}
