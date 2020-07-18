package problem.solving.implementation.easy;

import java.util.stream.IntStream;

public class ViralAdverstising {

	public static void main(String[] args) {
		System.out.println(viralAdvertising(3));

	}

	static int viralAdvertising(int n) {
		
		int[] result = new int[]{0, 5};

		IntStream.rangeClosed(1, n).forEach(x->{
			int likes = result[1]/2;
			result[0] += likes;
			result[1] = likes * 3;
		});
		
		return result[0];

    }
}
