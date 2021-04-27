package ib.scaler.day17_Feb14;

import java.util.Scanner;

public class SpecialInteger {

	public boolean check(int[] A, long X[], int B, int k) {
		int l = A.length;
		long sum = X[k - 1];

		if (sum > B)
			return false;

		for (int i = k; i < l; i++) {
			sum = X[i] - X[i - k];
			if (sum > B)
				return false;
		}

		return true;
	}

	public int solve(int[] A, int B) {
		int s, max, k, e;
		int l = A.length;
		s = max = 1;
		e = l;

		long X[] = new long[l];
		X[0] = A[0];
		for (int i = 1; i < l; i++)
			X[i] = X[i - 1] + (long) A[i];

		while (s <= e) {
			k = (s + e) / 2;
//			If k is possible, discard left else discard right. Since we need to find maximum of k
			if (check(A, X, B, k)) {
				s = k + 1;
				max = k;
			} else
				e = k - 1;
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int b = s.nextInt();

		SpecialInteger si = new SpecialInteger();
		System.out.println(si.solve(A, b));
		s.close();
	}
}
