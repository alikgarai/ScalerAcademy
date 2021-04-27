package ib.scaler.day36_Mar11;

import java.util.Arrays;
import java.util.Scanner;

public class CompareSortedSubarrays {

	public int[] solve(int[] A, int[][] B) {
		int l1, l2, r1, r2, n = A.length;

		long pSum[] = new long[n + 1];
		int pXOR[] = new int[n + 1];

		for (int i = 0; i < n; i++) {
			pSum[i + 1] = pSum[i] + A[i];
			pXOR[i + 1] = pXOR[i] ^ A[i];
		}
		n = B.length;
		int ans[] = new int[n];

		for (int i = 0; i < n; i++) {
			l1 = B[i][0];
			r1 = B[i][1];
			l2 = B[i][2];
			r2 = B[i][3];

			if ((pSum[r1 + 1] - pSum[l1] == pSum[r2 + 1] - pSum[l2])
					&& (pXOR[r1 + 1] ^ pXOR[l1]) == (pXOR[r2 + 1] ^ pXOR[l2]))
				ans[i] = 1;
			else
				ans[i] = 0;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		n = s.nextInt();
		int B[][] = new int[n][4];

		for (int i = 0; i < n; i++) {
			B[i][0] = s.nextInt();
			B[i][1] = s.nextInt();
			B[i][2] = s.nextInt();
			B[i][3] = s.nextInt();
		}
		System.out.println(Arrays.toString(new CompareSortedSubarrays().solve(A, B)));
		s.close();
	}
}
