package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class PainterPartitionProblem {

	public boolean check(int[] A, int B, long m) {
		int c = 1;
		int p = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > m)
				return false;
			p += A[i];
			if (p > m) {
				c++;
				p = A[i];
				if (c > B)
					return false;
			}
		}
		return true;
	}

	public int paint(int A, int B, int[] C) {

		long sum = 0, max = C[0], l = C.length;

		for (int i = 0; i < l; i++) {
			sum += C[i];
			max = Math.max(max, C[i]);
		}

		if (A >= l)
			return (int) ((max * B) % 10000003);
		if (A == 1)
			return (int) ((sum * B) % 10000003);

		long s, e, m, ans = 0;

		s = max;
		e = sum;

		while (s <= e) {
			m = (s + e) / 2;
			// check for m, if true discard right, else discard left
			if (check(C, A, m)) {
				ans = m;
				e = m - 1;
			} else
				s = m + 1;
		}
		return (int) ((ans * B) % 10000003);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int n = s.nextInt();
		int C[] = new int[n];

		for (int i = 0; i < n; i++)
			C[i] = s.nextInt();

		PainterPartitionProblem ppp = new PainterPartitionProblem();
		System.out.println(ppp.paint(a, b, C));
		s.close();
	}

}
