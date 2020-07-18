package problem.solving.implementation.easy;

import java.util.List;

public class BonAppetit {

	public static void main(String[] args) {
		

	}
	
	static void bonAppetit(List<Integer> bill, int k, int b) {

        int totalBill = bill.stream().reduce(0, Integer::sum);
        totalBill -= bill.get(k);
        int billForAnna = totalBill/2;
        System.out.println(b - billForAnna == 0 ? "Bon Appetit" : b-billForAnna);

    }

}
