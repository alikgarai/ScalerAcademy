package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class AllocateBooks {

	public boolean check(int[] A, int B, int m) {
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

	public int books(int[] A, int B) {
//		Arrays.sort(A);
		int s, e = 0, m, min, l = A.length;

		for (int i = 0; i < l; i++)
			e += A[i];

		s = A[0];
		min = e;

		if (B == 1)
			return e;
		if (B > l)
			return -1;

		while (s <= e) {
			m = (s + e) / 2;
			// check for m, if true discard right, else discard left
			if (check(A, B, m)) {
				min = Math.min(min, m);
				e = m - 1;
			} else
				s = m + 1;
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int b = s.nextInt();

		AllocateBooks ab = new AllocateBooks();
		System.out.println(ab.books(A, b));
		s.close();
	}
}

/*
 * 
 * Testing
 * 
 * 27 97 26 12 67 10 33 79 49 79 21 67 72 93 36 85 45 28 91 94 57 1 53 8 44 68
 * 90 24 26 OP: 97
 * 
 * 26 23 6 13 70 38 94 20 44 66 34 26 94 63 38 44 90 50 59 23 47 85 17 72 39 47
 * 85 7 OP: 222
 * 
 * 
 * 
 */