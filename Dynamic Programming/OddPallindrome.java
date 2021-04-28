package ib.scaler.day78_Apr27;

import java.util.Arrays;
import java.util.Scanner;

public class OddPallindrome {
	int mod = 1000000007;

	public int[] solve(String A) {
		int n = A.length();
		int[][] dp = new int[n][n];

		for (int len = n - 1; len >= 0; --len) {
			for (int i = 0; i + len < n; ++i) {
				int j = i + len;
				// Base cases
				if (i == 0 && j == n - 1) {
					if (A.charAt(i) == A.charAt(j))
						dp[i][j] = 2;
					else if (A.charAt(i) != A.charAt(j))
						dp[i][j] = 1;
				} else {
					if (A.charAt(i) == A.charAt(j)) {
						if (i - 1 >= 0) {
							dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
						}
						if (j + 1 <= n - 1) {
							dp[i][j] = (dp[i][j] + dp[i][j + 1]) % mod;
						}
						if (i - 1 < 0 || j + 1 >= n) {
							dp[i][j] += 1;
						}
					} else if (A.charAt(i) != A.charAt(j)) {
						// If the characters are not equal
						if (i - 1 >= 0) {
							dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
						}
						if (j + 1 <= n - 1) {
							dp[i][j] = (dp[i][j] + dp[i][j + 1]) % mod;
						}
						if (i - 1 >= 0 && j + 1 <= n - 1) {
							// Subtract it as we have
							// counted it twice
							dp[i][j] = Math.floorMod(dp[i][j] - dp[i - 1][j + 1], mod);
						}
					}
				}
			}
		}
		int[] ans = new int[n];
		for (int i = 0; i < n; ++i)
			ans[i] = (i == 0 || i == n - 1) ? 1 : dp[i - 1][i + 1];

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(Arrays.toString(new OddPallindrome().solve(s.next())));
		s.close();
	}

}
