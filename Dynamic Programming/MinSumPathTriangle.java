package ib.scaler.day83_May4;

import java.util.ArrayList;
import java.util.Scanner;

public class MinSumPathTriangle {

	public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
		int n = a.size();
		int[][] dp = new int[n][n];
		dp[0][0] = a.get(0).get(0);

		for (int i = 1; i < n; i++) {
			dp[i][0] = dp[i - 1][0] + a.get(i).get(0);
			dp[i][i] = dp[i - 1][i - 1] + a.get(i).get(i);
		}

		for (int i = 2; i < n; i++)
			for (int j = 1; j < i; j++)
				dp[i][j] = a.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);

		int min = dp[n - 1][0];
		for (int j = 1; j < n; j++)
			min = Math.min(min, dp[n - 1][j]);

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			for (int j = 0; j <= i; j++)
				tmp.add(s.nextInt());
			A.add(tmp);
		}
		System.out.println(new MinSumPathTriangle().minimumTotal(A));
		s.close();
	}

}
