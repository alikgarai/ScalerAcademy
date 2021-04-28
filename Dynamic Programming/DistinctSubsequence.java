package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class DistinctSubsequence {

	public int numDistinct(String A, String B) {
		int m = A.length();
		int n = B.length();

		int[][] dp = new int[n + 1][m + 1];

		for (int j = 0; j < m; j++)
			dp[0][j] = 1;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++)
				dp[i][j] = A.charAt(j - 1) == B.charAt(i - 1) ? dp[i][j - 1] + dp[i - 1][j - 1] : dp[i][j - 1];

		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new DistinctSubsequence().numDistinct(s.next(), s.next()));
		s.close();
	}

}
