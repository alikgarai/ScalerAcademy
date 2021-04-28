package ib.scaler.day72_Apr20;

import java.util.Scanner;

public class AnotherCoinProblem {

	public int solve(int A) {
		int count = 0;
		int x = 1;

		while (x <= A)
			x *= 5;

		while (A > 0) {
			count += A / x;
			A %= x;
			x /= 5;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print(new AnotherCoinProblem().solve(s.nextInt()));
		s.close();
	}
}
