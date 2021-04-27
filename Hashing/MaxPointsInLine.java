package ib.scaler.day38_Mar13;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class MaxPointsInLine {

	class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Pair that = (Pair) o;
			return x == that.x && y == that.y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
	}

	int gcd(int a, int b) {
		if (a == 1 || b == 1)
			return 1;
		if (a == 0 || b == 0)
			return Math.max(a, b);

		if (a > b)
			return gcd(a % b, b);
		else
			return gcd(a, b % a);
	}

	public int solve(int[] A, int[] B) {
		HashMap<Pair, Integer> hm = new HashMap<>();
		int x, y, m, val, maxCnt = 2, cnt;

		for (int i = 0; i < A.length; i++) {
			hm.clear();
			cnt = 0;
			for (int j = 0; j < A.length; j++) {
				if (i != j) {
					x = A[j] - A[i];
					y = B[j] - B[i];
					if (x == 0 && y == 0) {
						cnt++;
						continue;
					}

					m = gcd(Math.abs(x), Math.abs(y));
					x /= m;
					y /= m;

					Pair nod = new Pair(x, y);

					if (hm.containsKey(nod)) {
						val = hm.get(nod) + 1;
						hm.replace(nod, val);
						maxCnt = Math.max(maxCnt, val + cnt);
					} else
						hm.put(nod, 2);
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}

		return maxCnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[], B[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = s.nextInt();
		}
		System.out.print(new MaxPointsInLine().solve(A, B));
		s.close();
	}
}
