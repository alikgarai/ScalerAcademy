package ib.scaler.day80_Apr29;

import java.util.Arrays;
import java.util.Scanner;

public class LongestFibonacciSubset {

	public int solve(int[] A) {
		int n = A.length;
		int max = 0;
		int dp[][] = new int[n][n];

		for (int j = 1; j < n; j++)
			dp[0][j] = 2;

		for (int i = 1; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int v = A[j] - A[i];
				int ind = Arrays.binarySearch(A, 0, i, v);
				if (ind >= 0) {
					dp[i][j] = dp[ind][i] + 1;
					max = Math.max(max, dp[i][j]);
				} else
					dp[i][j] = 2;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new LongestFibonacciSubset().solve(A));
		s.close();
	}

}
