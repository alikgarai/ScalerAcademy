package ib.scaler.day07_Feb3;

import java.util.Scanner;

public class SumOfAllSubMatrices {

	public int solve(int[][] A) {
		int n, m, ans = 0;

		n = A.length;
		m = A[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ans += A[i][j] * (i + 1) * (j + 1) * (n - i) * (m - j);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, m, A[][];

		n = s.nextInt();
		m = s.nextInt();
		A = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				A[i][j] = s.nextInt();

		SumOfAllSubMatrices c = new SumOfAllSubMatrices();
		System.out.println(c.solve(A));
		s.close();
	}
}
