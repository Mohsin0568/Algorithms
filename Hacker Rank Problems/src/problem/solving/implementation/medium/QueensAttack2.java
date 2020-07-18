package problem.solving.implementation.medium;

public class QueensAttack2 {

	public static void main(String[] args) {
		
		int n = 5;
		int r_q = 4, c_q = 3;
		int[][] obstacles = {{5, 5}, {4, 2}, {2,3}};
		
		System.out.println(queensAttack(n, r_q, c_q, obstacles));

	}
	
	static int queensAttack(int n, int r_q, int c_q, int[][] obstacles) {
		
		int kills = 0;
		
		int a_vertical[] = {-1, -1};
		int b_vertical[] = {-1, -1};		 
		int a_horizontal[] = {-1, -1};
		int b_horizontal[] = {-1, -1};
		
		int upperRightDistance = -1;
		int upperLeftDistance = -1;
		int belowLeftDistance = -1;
		int belowRightDistance = -1;
		
		for(int[] x : obstacles){
			if(x[1] == c_q){
				if(x[0] < r_q){
					if(x[0] > b_vertical[0]){
						b_vertical = x;
					}					
				}
				else{
					if(a_vertical[0] == -1 || x[0] < a_vertical[0]){
						a_vertical = x;
					}
				}				
			}
			
			else if (x[0] == r_q){
				if(x[1] < c_q){
					if(b_horizontal[1] ==-1 || x[1] > b_horizontal[1]){
						b_horizontal = x;
					}
				}
				else{
					if(a_horizontal[1] ==-1 || x[1] < a_horizontal[1]){
						a_horizontal = x;
					}
				}
			}
			
			else if(Math.abs(r_q - x[0]) == Math.abs(c_q - x[1])){
				if(x[0] > r_q && x[1] < c_q){ // top left
					//int dist = x[0] - r_q - 1;
					int dist = c_q - x[1] - 1;
					if(upperLeftDistance == -1 || upperLeftDistance > dist)
						upperLeftDistance = dist;
				}
				
				if(x[0] > r_q && x[1] > c_q){ // top right
					int dist = x[1] - c_q - 1;
					if(upperRightDistance == -1 || upperRightDistance > dist)
						upperRightDistance = dist;					
				}
				
				if(x[0] < r_q && x[1] < c_q){ // bottom left
					int dist = c_q - x[1] - 1;
					if(belowLeftDistance == -1 || belowLeftDistance > dist)
						belowLeftDistance = dist;
				}
				else{ // bottom right
					int dist = x[1] - c_q -1;
					if(belowRightDistance == -1 || belowRightDistance > dist)
						belowRightDistance = dist;
				}
			}
		}
		
		kills += a_vertical[0] != -1 ? (a_vertical[0] - r_q - 1) : (n - r_q); // top steps
		kills += b_vertical[1] != -1 ? (r_q - b_vertical[0] -1) : r_q - 1;
		kills += a_horizontal[0] != -1 ? (a_horizontal[1] - c_q - 1) : (n - c_q);
		kills += b_horizontal[0] != -1 ? (c_q - b_horizontal[1] - 1) : c_q - 1;
		
		kills += upperLeftDistance != -1 ? upperLeftDistance : Math.min(c_q - 1, n - r_q); //getUpperLeftAttacks(n, r_q, c_q);
		kills += upperRightDistance != -1 ? upperRightDistance : Math.min(n - c_q, n - r_q); //getUpperRightAttacks(n, r_q, c_q);
		kills += belowLeftDistance != -1 ? belowLeftDistance : Math.min(c_q - 1, r_q - 1); //getBelowLeftAttacks(n, r_q, c_q);
		kills += belowRightDistance != -1 ? belowRightDistance : Math.min(n - c_q, r_q - 1); //getBelowRightAttacks(n, r_q, c_q);
		
		
		return kills;
    }
	
	private static int getUpperRightAttacks(int n, int r_q, int c_q){
		int attacks = 0;
		
		while(true){
			if(++r_q > n || ++c_q > n)
				break;
			attacks++;
		}
		
		return attacks;
	}
	
	private static int getUpperLeftAttacks(int n, int r_q, int c_q){
		int attacks = 0;
		
		while(true){
			if(++r_q > n || --c_q < 1)
				break;
			attacks++;
		}
		
		return attacks;
	}
	
	private static int getBelowLeftAttacks(int n, int r_q, int c_q){
		int attacks = 0;
		
		while(true){
			if(--r_q < 1 || --c_q < 1)
				break;
			attacks++;
		}
		
		return attacks;
	}
	
	private static int getBelowRightAttacks(int n, int r_q, int c_q){
		int attacks = 0;
		
		while(true){
			if(--r_q < 1 || ++c_q > n)
				break;
			attacks++;
		}
		
		return attacks;
	}

}
