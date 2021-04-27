package ib.scaler.day17_Feb14;

import java.util.Scanner;

public class MaxHeightStaircase {

	public int solve(int A) {

		long a = 2 * (long) A;
		long b = (long) Math.sqrt(a);

		if (b * (b + 1) <= a)
			return (int) b;
		else
			return (int) (b - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		MaxHeightStaircase ms = new MaxHeightStaircase();
		System.out.println(ms.solve(n));
		s.close();
	}

}
