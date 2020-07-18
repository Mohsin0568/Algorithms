package problem.solving.implementation.easy;

public class Kangaroo {
	
	static String kangaroo(int x1, int v1, int x2, int v2) {

		if(x1 > x2 && v1 >= v2)
			return "NO";
		else if(x2 > x1 && v2 >= v1)
			return "NO";
		else{
			if(x1 > x2){
				while(x2 < x1){
					x2 = x2 + v2;
					x1 = x1 + v1;
				}
			}
			else{
				while(x1 < x2){
					x2 = x2 + v2;
					x1 = x1 + v1;
				}
			}
			
			if(x1 == x2)
				return "YES";
			else
				return "NO";
		}

    }

	public static void main(String[] args) {
		System.out.println(kangaroo(1571, 4240, 9023, 4234));

	}

}
