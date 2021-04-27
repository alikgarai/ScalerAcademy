package ib.scaler.day68_Apr15;

import java.util.Scanner;

public class MagicianChocolate {

	int mod = 1000000007;

	void HeapUp(int[] A, int n) {
		if (n == 0)
			return;
		int parent = (n - 1) / 2;
		if (A[parent] < A[n]) {
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
		int tmp, maxInd = root, max = A[root];

		if (lc < n) {
			maxInd = A[lc] > max ? lc : maxInd;
			max = A[maxInd];
		}
		if (rc < n)
			maxInd = A[rc] > max ? rc : maxInd;

		if (lc == maxInd) {
			tmp = A[root];
			A[root] = A[lc];
			A[lc] = tmp;
			HeapDown(A, lc, n);
		} else if (rc == maxInd) {
			tmp = A[root];
			A[root] = A[rc];
			A[rc] = tmp;
			HeapDown(A, rc, n);
		}
	}

	public int nchoc(int A, int[] B) {
		int n = B.length;
		int X[] = new int[n];
		int maxChoc = 0;

		for (int i = 0; i < n; i++) {
			X[i] = B[i];
			HeapUp(X, i);
		}

		while (A-- > 0) {
			int val = X[0] / 2;
			maxChoc = (maxChoc + delMin(X, n) % mod) % mod;
			X[n - 1] = val;
			HeapUp(X, n - 1);
		}
		return maxChoc;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int n = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();
		System.out.println(new MagicianChocolate().nchoc(A, B));
		s.close();
	}

}
