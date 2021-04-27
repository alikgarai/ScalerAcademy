package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class XORqueries {

	public int[][] solve(int[] A, int[][] B) {

		int l = A.length;
		int ans[][] = new int[B.length][2];
		int setBits[] = new int[l];
		int x, y, cnt;

		setBits[0] = (A[0] == 1) ? 1 : 0;

		for (int i = 1; i < l; i++)
			setBits[i] = (A[i] == 1) ? (setBits[i - 1] + 1) : (setBits[i - 1]);

		for (int i = 0; i < B.length; i++) {
			x = B[i][0];
			y = B[i][1];

			cnt = (x == 1) ? setBits[y - 1] : setBits[y - 1] - setBits[x - 2];
			ans[i][0] = (cnt % 2 == 1) ? 1 : 0;
			ans[i][1] = y - x + 1 - cnt;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int A[] = new int[m];
		for (int i = 0; i < m; i++)
			A[i] = s.nextInt();
		m = s.nextInt();
		int n = s.nextInt();
		int B[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				B[i][j] = s.nextInt();

		XORqueries xq = new XORqueries();
		B = xq.solve(A, B);
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(B[i][j] + " ");
			System.out.println();
		}
		s.close();
	}
}
