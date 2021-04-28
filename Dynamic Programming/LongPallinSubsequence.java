package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class LongPallinSubsequence {

	int dp[][];

	int find(String A, int i, int j) {
		if (i > j)
			return 0;

		if (i == j)
			return 1;

		if (dp[i][j] != 0)
			return dp[i][j];

		if (A.charAt(i) == A.charAt(j))
			dp[i][j] = 2 + find(A, i + 1, j - 1);
		else
			dp[i][j] = Math.max(find(A, i + 1, j), find(A, i, j - 1));

		return dp[i][j];
	}

	public int solve(String A) {
		int n = A.length();
		dp = new int[n][n];

		return find(A, 0, n - 1);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(new LongPallinSubsequence().solve(s.next()));
		s.close();
	}
}
