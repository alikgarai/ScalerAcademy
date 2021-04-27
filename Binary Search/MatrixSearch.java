package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class MatrixSearch {

	public int binarySearch(int[] A, int B) {
		int piv, lo, hi;

		lo = 0;
		hi = A.length - 1;

		while (lo <= hi) {
			piv = (lo + hi) / 2;
			if (B == A[piv])
				return 1;
			else if (B > A[piv])
				lo = piv + 1;
			else
				hi = piv - 1;
		}

		return 0;
	}

	public int searchMatrix(int[][] A, int B) {

		int r = A.length;

		for (int i = r - 1; i >= 0; i--) {
			if (B >= A[i][0]) {
				return binarySearch(A[i], B);
			}
		}

		return 0;
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

		int b = s.nextInt();

		MatrixSearch ms = new MatrixSearch();
		System.out.println(ms.searchMatrix(A, b));
		s.close();
	}

}
