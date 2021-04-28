package ib.scaler.day119_Jun15;

import java.util.Scanner;

public class SchoolAssembly {

	int C, D, dp[][][][], mod = 1000000007;

	int ways(int consLen, int gender, int remBoys, int remGirls) {

		if (remBoys < 0 || remGirls < 0 || (gender == 0 && consLen > C) || (gender == 1 && consLen > D))
			return 0;

		if (remBoys == 0 && remGirls == 0)
			return 1;

		if (dp[consLen][gender][remBoys][remGirls] != -1)
			return dp[consLen][gender][remBoys][remGirls];

		long ans = 0;

		if (gender == 0)
			ans = (ans + ways(consLen + 1, 0, remBoys - 1, remGirls) + ways(1, 1, remBoys, remGirls - 1)) % mod;
		else
			ans = (ans + ways(1, 0, remBoys - 1, remGirls) + ways(consLen + 1, 1, remBoys, remGirls - 1)) % mod;

		dp[consLen][gender][remBoys][remGirls] = (int) ans;

		return (int) ans;
	}

	public int solve(int[] A) {
		C = A[2];
		D = A[3];

		int x = Math.max(C, D);
		dp = new int[x + 1][2][A[0] + 1][A[1] + 1];

		for (int i = 0; i <= x; i++)
			for (int j = 0; j < 2; j++)
				for (int k = 0; k <= A[0]; k++)
					for (int l = 0; l <= A[1]; l++)
						dp[i][j][k][l] = -1;

		return (ways(1, 0, A[0] - 1, A[1]) + ways(1, 1, A[0], A[1] - 1)) % mod;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A[] = new int[4];
		for (int i = 0; i < 4; i++)
			A[i] = s.nextInt();
		System.out.println(new SchoolAssembly().solve(A));
		s.close();
	}

}
