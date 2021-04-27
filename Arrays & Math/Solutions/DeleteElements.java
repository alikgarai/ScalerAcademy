package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class DeleteElements {

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
			return -1;
		int g = gcd(A[0], A[1]);
		for (int i = 2; i < A.length; i++) {
			g = gcd(g, A[i]);
		}
		if (g != 1)
			return -1;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		DeleteElements de = new DeleteElements();
		System.out.println(de.solve(A));
		s.close();
	}

}
