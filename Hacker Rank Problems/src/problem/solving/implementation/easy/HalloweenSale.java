package problem.solving.implementation.easy;

public class HalloweenSale {

	public static void main(String[] args) {
		System.out.println(howManyGames(20, 3, 6, 85));

	}
	
	static int howManyGames(int p, int d, int m, int s) {
        
		int noOfGames = 0;
		int totalAmountSpent = 0;
		
		while(true){
			
			totalAmountSpent += p;
			if(totalAmountSpent <= s){
				noOfGames++;
				p -= d;
				if(p < m)
					p = m;
			}
			else{
				break;
			}
			
			
		}
		
		
		return noOfGames;

    }

}
