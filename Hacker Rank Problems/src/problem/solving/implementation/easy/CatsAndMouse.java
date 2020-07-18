package problem.solving.implementation.easy;

public class CatsAndMouse {

	public static void main(String[] args) {
		System.out.println(catAndMouse(1, 2, 3));

	}
	
	static String catAndMouse(int x, int y, int z) {
        int catOneDistance = Math.abs(x-z);
        int catTwoDistance = Math.abs(y-z);
        
        if(catOneDistance == catTwoDistance)
            return "Mouse C";
        else if (catOneDistance > catTwoDistance)
            return "Cat B";
        else
            return "Cat A";

    }

}
