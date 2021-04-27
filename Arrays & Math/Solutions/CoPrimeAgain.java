package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class CoPrimeAgain {

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

	public int solve(int[] A, int[] B, int C) {
		int c1 = 0, c2 = 0;

		for (int i = 0; i < A.length; i++)
			if (gcd(A[i], C) == 1)
				c1++;

		for (int i = 0; i < B.length; i++)
			if (gcd(B[i], C) == 1)
				c2++;

		return (A.length * B.length - c1 * c2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n, m, k;

		n = s.nextInt();
		m = s.nextInt();
		k = s.nextInt();
		int A[] = new int[n];
		int B[] = new int[m];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		for (int i = 0; i < m; i++)
			B[i] = s.nextInt();

		CoPrimeAgain cp = new CoPrimeAgain();
		System.out.println(cp.solve(A, B, k));
		s.close();
	}
}
