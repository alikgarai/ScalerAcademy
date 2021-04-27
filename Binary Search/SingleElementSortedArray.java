package ib.scaler.day17_Feb14;

import java.util.Scanner;

public class SingleElementSortedArray {

	public int solve(int[] A) {
		if (A.length == 1)
			return A[0];

		if (A.length == 2) {
			if (A[0] != A[1])
				return 1;
			if (A[0] == A[1])
				return 0;
		}
		int i;
		for (i = 0; i < A.length - 1; i += 2) {
			if (A[i] != A[i + 1])
				return A[i];
		}

		return A[i];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		SingleElementSortedArray sa = new SingleElementSortedArray();
		System.out.println(sa.solve(A));
		s.close();
	}

}
