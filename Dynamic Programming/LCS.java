package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class LCS {

	public int solve(String A, String B) {
		int m = A.length();
		int n = B.length();
		int x = 1;

		if (m < n) {
			String tmp = A;
			A = B;
			B = tmp;
			int l = m;
			m = n;
			n = l;
		}

		int dp[][] = new int[2][n + 1];

		for (int i = 1; i <= m; i++) {
			x = i % 2;
			for (int j = 1; j <= n; j++) {

				if (A.charAt(i - 1) == B.charAt(j - 1))
					dp[x][j] = dp[1 - x][j - 1] + 1;

				else
					dp[x][j] = Math.max(dp[1 - x][j], dp[x][j - 1]);
			}
		}
		return dp[x][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LCS().solve(s.next(), s.next()));
		s.close();
	}

}
