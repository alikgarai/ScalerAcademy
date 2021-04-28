package ib.scaler.day83_May4;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {
	int[][] dp;

	int calc(int[] A, int i, int j) {
		if (i == j)
			return 0;

		if (dp[i][j] != Integer.MAX_VALUE)
			return dp[i][j];

		for (int k = i; k < j; k++) {
			int count = calc(A, i, k) + calc(A, k + 1, j) + A[i - 1] * A[k] * A[j];

			dp[i][j] = Math.min(dp[i][j], count);
		}
		return dp[i][j];
	}

	public int solve(int[] A) {
		int n = A.length;
		dp = new int[n][n];
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], Integer.MAX_VALUE);

		return calc(A, 1, n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new MatrixChainMultiplication().solve(A));
		s.close();
	}

}
