package ib.scaler.day68_Apr15;

import java.util.Scanner;

public class SortedMatrix {

	void HeapUp(int[] A, int n) {
		if (n == 0)
			return;
		int parent = (n - 1) / 2;
		if (A[parent] > A[n]) {
			int tmp = A[parent];
			A[parent] = A[n];
			A[n] = tmp;
			HeapUp(A, parent);
		}
	}

	int delMin(int[] A, int n) {
		int min = A[0];
		A[0] = A[n - 1];
		HeapDown(A, 0, --n);
		return min;
	}

	void HeapDown(int[] A, int root, int n) {

		int lc = 2 * root + 1;
		int rc = 2 * root + 2;
		int tmp, minInd = root, min = A[root];

		if (lc < n) {
			minInd = A[lc] < min ? lc : minInd;
			min = A[minInd];
		}
		if (rc < n)
			minInd = A[rc] < min ? rc : minInd;

		if (lc == minInd) {
			tmp = A[root];
			A[root] = A[lc];
			A[lc] = tmp;
			HeapDown(A, lc, n);
		} else if (rc == minInd) {
			tmp = A[root];
			A[root] = A[rc];
			A[rc] = tmp;
			HeapDown(A, rc, n);
		}
	}

	public int solve(int[][] A, int B) {
		int m = A.length;
		int n = A[0].length;

		int l = m * n;
		int X[] = new int[l];
		int x = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				X[x] = A[i][j];
				HeapUp(X, x++);
			}
		}
		while (B-- > 1)
			delMin(X, l--);

		return delMin(X, l);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int A[][] = new int[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				A[i][j] = s.nextInt();
		int B = s.nextInt();
		System.out.println(new SortedMatrix().solve(A, B));
		s.close();
	}

}
