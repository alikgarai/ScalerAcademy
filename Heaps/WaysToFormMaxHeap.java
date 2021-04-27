package ib.scaler.day70_Apr17;

import java.util.HashMap;
import java.util.Scanner;

public class WaysToFormMaxHeap {

	HashMap<Integer, Integer> hm = new HashMap<>();
	int mod = 1000000007;

	long calculateNCR(int n, int r) {
		r = (r < n - r) ? r : n - r;
		long nmod = 1, dmod = 1;

		for (int i = n; i > n - r; i--)
			nmod = (nmod * i) % mod;

		for (int i = r; i > 1; i--)
			dmod = (dmod * i) % mod;

		long x = 1;
		int p = mod - 2;

		while (p > 0) {
			if (p % 2 == 1) {
				x = (x * dmod) % mod;
			}
			dmod = (dmod * dmod) % mod;
			p /= 2;
		}

		return (int) ((nmod * x) % mod);
	}

	public int solve(int A) {
		if (A <= 2)
			return 1;
		if (hm.containsKey(A))
			return hm.get(A);

		int H = (int) (Math.log(A) / Math.log(2));
		int X = (int) Math.pow(2, H) - 1;
		int L = (X - 1) / 2 + Math.min(A - X, (X + 1) / 2);
		int R = A - 1 - L;

		int val = (int) ((long) solve(L) * (long) solve(R) % mod * calculateNCR(A - 1, L) % mod);
		hm.put(A, val);

		return hm.get(A);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		System.out.println(new WaysToFormMaxHeap().solve(A));
		s.close();
	}
}
