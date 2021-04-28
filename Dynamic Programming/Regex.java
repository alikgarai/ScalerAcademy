package ib.scaler.day78_Apr27;

import java.util.Scanner;

public class Regex {

	public int isMatch(final String A, final String B) {
		int m = A.length();
		int n = B.length();

		boolean[][] dp = new boolean[n + 1][m + 1];

		dp[0][0] = true;

		for (int j = 1; j <= m; j++)
			dp[0][j] = false;

		for (int i = 1; i <= n; i++) {
			if (B.charAt(i - 1) == '*')
				dp[i][0] = dp[i - 1][0];
			else
				dp[i][0] = false;
		}

		for (int i = 1; i <= n; i++) {
			char c = B.charAt(i - 1);
			for (int j = 1; j <= m; j++) {
				if (c == '?')
					dp[i][j] = dp[i - 1][j - 1];
				else if (c != '*') {
					if (c == A.charAt(j - 1))
						dp[i][j] = dp[i - 1][j - 1];
					else
						return 0;
				} else {
					dp[i][j] = true;
//					dp[i][j] = dp[i - 1][j];
//					int curr_j = j;
//					while (curr_j > 0 && A.charAt(curr_j - 1) == A.charAt(j - 1)) {
//						dp[i][j] |= dp[i - 1][curr_j - 1];
//						curr_j--;
//					}
				}
			}
		}

		return dp[n][m] == true ? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new Regex().isMatch(s.next(), s.next()));
		s.close();
	}

}
