package ib.scaler.day80_Apr29;

import java.util.Scanner;

public class CoinSumInfinite {

	public int coinchange2(int[] A, int B) {
		int[] dp = new int[B + 1];
		int mod = 1000007;
		dp[0] = 1;

		for (int j = 0; j < A.length; j++) {
			for (int i = A[j]; i <= B; i++) {
				dp[i] = (dp[i] + dp[i - A[j]]) % mod;
			}
		}
		return dp[B];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new CoinSumInfinite().coinchange2(A, s.nextInt()));
		s.close();
	}

}
