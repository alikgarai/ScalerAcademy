package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class EditDistance {

	public int minDistance(String A, String B) {
		int m = A.length();
		int n = B.length();
		int x = 0, y;

		if (n < m) {
			String tmp = A;
			A = B;
			B = tmp;
			int t = n;
			n = m;
			m = t;
		}

		int[][] dp = new int[2][m + 1];

		for (int i = 0; i <= n; i++) {
			x = i & 1;
			y = (x + 1) & 1;
			for (int j = 0; j <= m; j++) {

				if (i == 0 && j == 0)
					dp[x][j] = 0;

				else if (i == 0 || j == 0)
					dp[x][j] = Math.max(i, j);

				else if (B.charAt(i - 1) == A.charAt(j - 1))
					dp[x][j] = dp[y][j - 1];

				else
					dp[x][j] = 1 + Math.min(Math.min(dp[y][j - 1], dp[y][j]), dp[x][j - 1]);
			}
		}

		return dp[x][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new EditDistance().minDistance(s.next(), s.next()));
		s.close();
	}
}
