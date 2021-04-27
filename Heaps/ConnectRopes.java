package ib.scaler.day68_Apr15;

import java.util.Scanner;

public class ConnectRopes {

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

	public int solve(int[] A) {
		int n = A.length;
		int X[] = new int[n];
		int minCost = 0, cost;

		for (int i = 0; i < n; i++) {
			X[i] = A[i];
			HeapUp(X, i);
		}

		while (n > 1) {
			cost = delMin(X, n--);
			cost += delMin(X, n);
			X[n - 1] = cost;
			HeapUp(X, n - 1);

			minCost += cost;
		}
		return minCost;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new ConnectRopes().solve(A));
		s.close();
	}

}
