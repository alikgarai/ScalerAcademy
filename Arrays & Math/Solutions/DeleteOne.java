package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class DeleteOne {

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
		int l = A.length;
		int pr[] = new int[l];
		int sf[] = new int[l];

		pr[0] = A[0];
		sf[l - 1] = A[l - 1];

		for (int i = 1; i < l; i++) {
			pr[i] = gcd(pr[i - 1], A[i]);
		}

		for (int i = l - 2; i >= 0; i--) {
			sf[i] = gcd(sf[i + 1], A[i]);
		}

		int max = 1;

		for (int i = 1; i < l - 1; i++) {
			max = Math.max(max, gcd(pr[i - 1], sf[i + 1]));
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		DeleteOne c = new DeleteOne();
		System.out.println(c.solve(A));

		s.close();
	}

}
