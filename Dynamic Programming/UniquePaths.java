package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class UniquePaths {

	public int uniquePathsWithObstacles(int[][] A) {
		int n = A.length;
		int m = A[0].length;

		int dp[][] = new int[n][m];

		for (int i = 0; i < n; i++) {
			if (A[i][0] == 1)
				break;
			dp[i][0] = 1;
		}
		for (int j = 0; j < m; j++) {
			if (A[0][j] == 1)
				break;
			dp[0][j] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (A[i][j] == 1)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[n - 1][m - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();

		int A[][] = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				A[i][j] = s.nextInt();
		System.out.println(new UniquePaths().uniquePathsWithObstacles(A));
		s.close();
	}
}
