package ib.scaler.day29_Mar2;

import java.util.Arrays;
import java.util.Scanner;

public class ReversePairs {

	int cnt = 0;

	void divide(int[] A, int l, int r) {
		if (l >= r)
			return;
		int m = (l + r) / 2;

		divide(A, l, m);
		divide(A, m + 1, r);
		conquer(A, l, m, r);
	}

	void conquer(int[] A, int l, int m, int r) {
		int s = l, e = m + 1;
		long val;

		while (s <= m && e <= r) {
			if (A[s] < A[e]) {
				s++;
			} else {
				val = (long) 2 * A[e];
				if (A[s] > val) {
					cnt += m - s + 1;
					e++;
				} else
					s++;
			}
		}
		Arrays.sort(A, l, r + 1);
	}

	public int solve(int[] A) {
		divide(A, 0, A.length - 1);
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.print(new ReversePairs().solve(A));
		s.close();
	}
}
