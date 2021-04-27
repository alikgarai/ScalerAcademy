package ib.scaler.day17_Feb14;

import java.util.Scanner;

public class RotatedSortedArraySearch {

	public int findPivot(final int[] A) {
		int lo = 0;
		int hi = A.length - 1;
		int piv = (lo + hi) / 2;

		while (piv > lo && piv < hi) {
			if (A[piv] < A[piv - 1] && A[piv] < A[piv + 1])
				return piv;
			else if (A[piv] > A[0])
				lo = piv + 1;
			else
				hi = piv - 1;

			piv = (lo + hi) / 2;
		}
		return piv;
	}

	public int binarySearch(int[] A, int lo, int hi, int B) {
		int piv;

		while (lo <= hi) {
			piv = (lo + hi) / 2;
			if (B == A[piv])
				return piv;
			else if (B > A[piv])
				lo = piv + 1;
			else
				hi = piv - 1;
		}

		return -1;
	}

	public int search(final int[] A, int B) {

		int piv = findPivot(A);

		if (piv > 0) {
			int x = binarySearch(A, 0, piv - 1, B);
			int y = binarySearch(A, piv, A.length - 1, B);

			if (x != -1)
				return x;
			else if (y != -1)
				return y;
			else
				return -1;
		} else
			return binarySearch(A, piv, A.length - 1, B);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int b = s.nextInt();

		RotatedSortedArraySearch rs = new RotatedSortedArraySearch();
		System.out.println(rs.search(A, b));
		s.close();
	}

}
