package problem.solving.implementation.easy;

import java.util.concurrent.atomic.AtomicInteger;

public class DesignerPDFViewer {

	public static void main(String[] args) {
		System.out.println(designerPdfViewer(new int[]{1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7}, "abc"));

	}
	
	static int designerPdfViewer(int[] h, String word) {

        AtomicInteger highestHeigh = new AtomicInteger(1);
        
        word.chars().forEach( x -> {
            int diff = x - 97;
            if(h[diff] > highestHeigh.get())
                highestHeigh.set(h[diff]);
        });
        
        return word.length() * highestHeigh.get();

    }

}
