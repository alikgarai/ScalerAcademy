package ib.scaler.day83_May4;

import java.util.Arrays;
import java.util.Scanner;

public class NDigitNumbers {
	int mod = 1000000007;
	int[][] dp;

	int find(int remDigits, int remSum) {

		if (remDigits == 0 && remSum == 0)
			return 1;

		if (remDigits == 0 || remSum < 0)
			return 0;

		if (dp[remDigits][remSum] != -1)
			return dp[remDigits][remSum];

		dp[remDigits][remSum] = 0;
		for (int i = 0; i <= 9 && i <= remSum; i++)
			dp[remDigits][remSum] = (dp[remDigits][remSum] + find(remDigits - 1, remSum - i)) % mod;

		return dp[remDigits][remSum];
	}

	public int solve(int A, int B) {

		dp = new int[A + 1][B + 1];
		for (int i = 0; i <= A; i++)
			Arrays.fill(dp[i], -1);

		dp[A][B] = 0;
		for (int i = 1; i <= 9 && i <= B; i++)
			dp[A][B] = (dp[A][B] + find(A - 1, B - i)) % mod;

		return dp[A][B];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new NDigitNumbers().solve(s.nextInt(), s.nextInt()));
		s.close();
	}

}
