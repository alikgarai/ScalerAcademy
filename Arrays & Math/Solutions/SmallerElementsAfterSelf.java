package ib.scaler.day29_Mar2;

import java.util.Arrays;
import java.util.Scanner;

public class SmallerElementsAfterSelf {

	class Pair implements Comparable<Pair> {
		int val;
		int idx;

		Pair(int a, int b) {
			val = a;
			idx = b;
		}

		public int compareTo(Pair p) {
			return val - p.val;
		}
	}

	int ans[];

	void divide(Pair[] X, int l, int r) {
		if (l >= r)
			return;
		int m = (l + r) / 2;

		divide(X, l, m);
		divide(X, m + 1, r);
		conquer(X, l, m, r);
	}

	void conquer(Pair[] A, int l, int m, int r) {

		int j = m + 1;
		for (int i = l; i <= m; i++) {
			while (j <= r && A[j].val < A[i].val)
				j++;
			ans[A[i].idx] += j - m - 1;
		}
		Arrays.sort(A, l, r + 1);
	}

	public int[] solve(int[] A) {
		ans = new int[A.length];
		Pair[] X = new Pair[A.length];
		for (int i = 0; i < A.length; i++)
			X[i] = new Pair(A[i], i);

		divide(X, 0, A.length - 1);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.print(Arrays.toString(new SmallerElementsAfterSelf().solve(A)));
		s.close();
	}

}
