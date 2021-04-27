package ib.scaler.day70_Apr17;

import java.util.Arrays;
import java.util.Scanner;

public class AthMaxElement {

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

	public int[] solve(int A, int[] B) {
		int n = B.length;
		int ans[] = new int[n];
		int X[] = new int[A];
		int x = 0;

		for (int i = 0; i < A; i++) {
			X[x] = B[i];
			HeapUp(X, x++);
			ans[i] = -1;
		}
		ans[A - 1] = X[0];

		for (int i = A; i < n; i++) {
			if (B[i] > X[0]) {
				X[0] = B[i];
				HeapDown(X, 0, x);
			}
			ans[i] = X[0];
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int n = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();
		System.out.println(Arrays.toString(new AthMaxElement().solve(A, B)));
		s.close();
	}

}
