package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class MatrixMedian {

	public int check(int[][] A, int mid, int mcnt) {
		int lsum, rsum, l, s, e;
		boolean flg, flg1 = false;
		lsum = rsum = 0;
		l = A[0].length;

		for (int i = 0; i < A.length; i++) {
			int piv, lo, hi;
			lo = 0;
			hi = l - 1;
			flg = false;
			while (lo <= hi) {
				piv = (lo + hi) / 2;
				if (mid == A[i][piv]) {
					s = e = piv;
					while (s >= 0 && mid == A[i][s])
						s--;
					while (e < l && mid == A[i][e])
						e++;
					lsum += s + 1; // numbers less than mid
					rsum += e; // numbers less than and equal to mid
					flg = true;
					flg1 = true;
					break;
				} else if (mid > A[i][piv])
					lo = piv + 1;
				else
					hi = piv - 1;
			}
			if (flg == true)
				continue;
			else {
				lsum += hi + 1;
				rsum += hi + 1;
			}
		}
		if (lsum == mcnt) {
			if (flg1 == true)
				return 0;
			else
				return 1;
		} else if (lsum < mcnt) {
			if (rsum > mcnt)
				return 0;
			else
				return 1;
		} else
			return -1;
	}

	public int findMedian(int[][] A) {

		int r = A.length;
		int c = A[0].length;
		int mcnt = (r * c) / 2;

		int min = A[0][0];
		int max = A[0][c - 1];
		int mid;

		for (int i = 1; i < r; i++) {
			if (min > A[i][0])
				min = A[i][0];

			if (max < A[i][c - 1])
				max = A[i][c - 1];
		}

		while (min <= max) {
			mid = (min + max) / 2;
			int ans = check(A, mid, mcnt);
			if (ans == 0) {
				return mid;
			} else if (ans == 1) // Look for numbers greater than mid.
				min = mid + 1;
			else
				max = mid - 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int A[][] = new int[m][n];

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = s.nextInt();

		MatrixMedian mm = new MatrixMedian();
		System.out.println(mm.findMedian(A));
		s.close();
	}
}

/*
 * Test
 * 
 * 11 1 5 4 3 1 3 1 4 2 5 3 3 OP: 3
 */