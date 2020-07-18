package problem.solving.implementation.easy;

public class FairRations {

	public static void main(String[] args) {
		
		fairRations(new int[]{2, 3, 4, 5, 6});

	}
	
	static String fairRations(int[] b) {

		int distributions = 0;
		
		for(int i = 0 ; i < b.length-1 ; i++){
			
			if(b[i] % 2 != 0){
				b[i] += 1;
				distributions++;
				if(i != b.length -1){
					b[i+1] += 1;
					distributions++;
				}
			}			
		}
		
		if(b[b.length-1] %2 == 0){
			return distributions + "";
		}
		else{
			return "no";
		}
    }

}
