package ib.scaler.day73_Apr21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

//public class AnotherGCDProblem {
//	public int GCD(int A, int B) {
//		if (A == 1 || B == 1)
//			return 1;
//		if (A == 0 || B == 0)
//			return Math.max(A, B);
//
//		if (A > B)
//			return GCD(A % B, B);
//		else if (A < B)
//			return GCD(A, B % A);
//		else
//			return A;
//	}
//
//	public int solve(int[] A) {
//		int gcd = A[0];
//		int l = 0, r = 0, max = -1;
//
//		while (r < A.length) {
//			gcd = GCD(gcd, A[r]);
//			if (gcd > 1)
//				max = Math.max(max, r - l + 1);
//			else {
//				for (int i = r; i >= l; i--) {
//					int temp = GCD(A[i], A[r]);
//					if (temp == 1) {
//						l = i + 1;
//						break;
//					}
//					gcd = temp;
//				}
//			}
//			r++;
//		}
//		return max;
//	}
//}

public class AnotherGCDProblem {

	ArrayList<Integer> Primes = new ArrayList<>();
	HashMap<Integer, ArrayList<Integer>> ans = new HashMap<>();

	void createPrimeArray() {
		int l = 1000;
		long X[] = new long[l + 1];

		for (int i = 2; i < l; i++) {
			if (X[i] == 0) {
				Primes.add(i);
				ans.put(i, new ArrayList<>());
				for (int j = i * i; j < l; j += i)
					X[j] = 1;
			}
		}
	}

	public int solve(int[] A) {
		createPrimeArray();
		int flg;
		ArrayList<Integer> x;

		for (int i = 0; i < A.length; i++) {
			flg = 0;
			for (int j = 0; j < Primes.size(); j++) {
				int p = Primes.get(j);
				if (A[i] % p == 0) {
					ans.get(p).add(i);
					flg = 1;
				}
			}
			if (flg == 0 && A[i] > 1) {
				x = new ArrayList<>();
				x.add(i);
				ans.put(A[i], x);
				Primes.add(A[i]);
			}
		}

		int max = -1, l, p, q, len;
		Iterator<Map.Entry<Integer, ArrayList<Integer>>> it = ans.entrySet().iterator();

		while (it.hasNext()) {
			x = it.next().getValue();
			len = x.size();
			if (len == 0)
				continue;
			p = 0;
			q = 1;
			l = 0;
			while (q < len) {
				if (x.get(q) != x.get(q - 1) + 1) {
					l = Math.max(l, q - p);
					p = q;
				}
				q++;
			}
			l = Math.max(l, q - p);
			max = Math.max(max, l);
		}

		return max;
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
		System.out.print(new AnotherGCDProblem().solve(A));
		s.close();
	}

}
