package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class DivisorGame {

	public int gcd(int A, int B) {
		if (A == 1 || B == 1)
			return 1;
		if (A == 0 || B == 0)
			return Math.max(A, B);

		if (A > B)
			return gcd(A % B, B);
		if (A < B)
			return gcd(A, B % A);

		if (A == B)
			return A;

		return -1;
	}

	public int solve(int A, int B, int C) {

		long prod = (B * C) / gcd(B, C);

		if (A >= prod) {
			return ((int) (A / prod));
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		DivisorGame dg = new DivisorGame();
		System.out.println(dg.solve(a, b, c));
		s.close();
	}

}
