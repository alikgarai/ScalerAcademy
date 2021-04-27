package ib.scaler.day108_Jun3;

import java.util.Scanner;

public class PrimeSubsequences {

	public boolean isPrime(int n) {
		if (n == 1)
			return false;
		if (n == 2)
			return true;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public int solve(int[] A) {

		int mod = 1000000007;
		int cnt = 0;

		for (int i = 0; i < A.length; i++) {
			if (isPrime(A[i]))
				cnt++;
		}
		long x = 0;

		while (cnt-- > 0) {
			x = (x * 2 + 1) % mod;
		}
		return (int) x;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new PrimeSubsequences().solve(A));
		s.close();
	}

}
