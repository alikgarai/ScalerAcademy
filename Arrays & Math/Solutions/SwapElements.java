package ib.scaler.day35_Mar8;

import java.util.Scanner;

public class SwapElements {

	public int[] solve(int[] A, int[][] B) {

		int ans[] = new int[B.length];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++)
			max = Math.max(max, A[i]);

		for (int i = 0; i < B.length; i++) {
			if (B[i][1] == 0)
				ans[i] = A[B[i][0] - 1];
			else if (B[i][1] > 1 || B[i][0] == 1)
				ans[i] = max;

			else {
				int l = B[i][0];
				int x = (int) Math.sqrt(l);
				int m = A[0];
				for (int j = 1; j <= x; j++) {
					if (l % j == 0) {
						m = Math.max(m, A[j - 1]);
						m = Math.max(m, A[(l / j) - 1]);
					}
				}
				for (int j = 2 * l; j <= A.length; j += l) {
					m = Math.max(m, A[j - 1]);
				}
				ans[i] = m;
			}
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
		int B[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			B[i][0] = s.nextInt();
			B[i][1] = s.nextInt();
		}
		SwapElements se = new SwapElements();
		A = se.solve(A, B);
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
		s.close();
	}

}

/*
 * 5 2 4 6 3 2 3
 * 
 * 5 1 4 1 4 0
 */
