package ib.scaler.day80_Apr29;

import java.util.Scanner;

public class SubMatrixSubQueries {

	public int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {

		int ans[] = new int[B.length];
		int n, m, i, j, b, c, d, e;
		long val;

		n = A.length;
		m = A[0].length;
		long pr[][] = new long[n][m];
		pr[0][0] = A[0][0];

		for (j = 1; j < m; j++) {
			val = pr[0][j - 1] + A[0][j];
			pr[0][j] = val;
		}

		for (i = 1; i < n; i++) {
			val = pr[i - 1][0] + A[i][0];
			pr[i][0] = val;
		}

		for (i = 1; i < n; i++)
			for (j = 1; j < m; j++) {
				val = pr[i][j - 1] + pr[i - 1][j] - pr[i - 1][j - 1] + A[i][j];
				pr[i][j] = val;
			}

		for (int x = 0; x < B.length; x++) {
			b = B[x] - 1;
			c = C[x] - 1;
			d = D[x] - 1;
			e = E[x] - 1;
			if (b > 0 && c > 0) {
				val = pr[d][e] - pr[d][c - 1] - pr[b - 1][e] + pr[b - 1][c - 1];
			} else if (b > 0) {
				val = pr[d][e] - pr[b - 1][e];
			} else if (c > 0) {
				val = pr[d][e] - pr[d][c - 1];
			} else
				val = pr[d][e];

			ans[x] = (int) (Math.floorMod(val, 1000000007));
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int i, j, n, m, l, A[][], B[], C[], D[], E[], Q[];

		n = s.nextInt();
		m = s.nextInt();
		l = s.nextInt();

		A = new int[n][m];
		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++)
				A[i][j] = s.nextInt();

		B = new int[l];
		C = new int[l];
		D = new int[l];
		E = new int[l];
		Q = new int[l];

		for (i = 0; i < l; i++) {
			B[i] = s.nextInt();
			C[i] = s.nextInt();
			D[i] = s.nextInt();
			E[i] = s.nextInt();
		}

		SubMatrixSubQueries c = new SubMatrixSubQueries();
		Q = c.solve(A, B, C, D, E);
		for (i = 0; i < l; i++) {
			System.out.print(Q[i] + " ");
		}
		s.close();
	}

}
