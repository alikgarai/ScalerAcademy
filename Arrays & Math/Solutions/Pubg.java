package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class Pubg {

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

	public int solve(int[] A) {
		if (A.length == 1)
			return A[0];
		int g = gcd(A[0], A[1]);
		if (A.length == 2)
			return g;

		for (int i = 2; i < A.length; i++) {
			g = gcd(g, A[i]);
		}
		return g;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		Pubg pubg = new Pubg();
		System.out.println(pubg.solve(A));
		s.close();
	}

}
