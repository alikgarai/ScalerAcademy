package ib.scaler.day68_Apr15;

import java.util.Scanner;

public class MishaAndCandies {

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

	public int solve(int[] A, int B) {
		int n = A.length;
		int X[] = new int[n];
		int maxChoc = 0;

		for (int i = 0; i < n; i++) {
			X[i] = A[i];
			HeapUp(X, i);
		}

		for (int i = 0; i < A.length; i++) {
			if (X[0] > B)
				break;

			int val = delMin(X, n--);
			X[0] += val - (val / 2);
			HeapDown(X, 0, n);
			maxChoc += val / 2;
		}
		return maxChoc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B = s.nextInt();
		System.out.println(new MishaAndCandies().solve(A, B));
		s.close();
	}

}
