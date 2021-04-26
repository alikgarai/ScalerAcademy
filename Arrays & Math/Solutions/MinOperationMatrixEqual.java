package ib.scaler.day07_Feb3;

import java.util.Arrays;
import java.util.Scanner;

public class MinOperationMatrixEqual {

	public int solve(int[][] A, int B) {
		int n, m, mod, X[], median, sum = 0;
		n = A.length;
		m = A[0].length;
		X = new int[m * n];
		mod = Math.floorMod(A[0][0], B);
		int x = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (Math.floorMod(A[i][j], B) != mod)
					return -1;
				X[x++] = A[i][j];
			}
		}
		Arrays.sort(X);
		median = X[x / 2];
		for (int i = 0; i < x; i++) {
			sum += Math.abs(X[i] - median) / B;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int b, A[][], x, y;

		x = s.nextInt();
		y = s.nextInt();
		A = new int[x][y];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				A[i][j] = s.nextInt();
			}
		}
		b = s.nextInt();

		MinOperationMatrixEqual c = new MinOperationMatrixEqual();
		System.out.println(c.solve(A, b));

		s.close();
	}
}
