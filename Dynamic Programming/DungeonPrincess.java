package ib.scaler.day80_Apr29;

import java.util.Scanner;

public class DungeonPrincess {

	public int calculateMinimumHP(int[][] A) {

		int m = A.length;
		int n = A[0].length;

		int[][] dp = new int[m][n];
		dp[m - 1][n - 1] = A[m - 1][n - 1] < 0 ? 1 - A[m - 1][n - 1] : 1;

		for (int i = m - 2; i >= 0; i--) {
			dp[i][n - 1] = dp[i + 1][n - 1] - A[i][n - 1];
			dp[i][n - 1] = dp[i][n - 1] <= 0 ? 1 : dp[i][n - 1];
		}

		for (int j = n - 2; j >= 0; j--) {
			dp[m - 1][j] = dp[m - 1][j + 1] - A[m - 1][j];
			dp[m - 1][j] = dp[m - 1][j] <= 0 ? 1 : dp[m - 1][j];
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j];
				dp[i][j] = dp[i][j] <= 0 ? 1 : dp[i][j];
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int[][] A = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = s.nextInt();
		System.out.println(new DungeonPrincess().calculateMinimumHP(A));
		s.close();
	}

}
