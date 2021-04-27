package ib.scaler.day24_Feb25;

import java.util.ArrayList;
import java.util.Scanner;

public class XORPrime {

	ArrayList<Integer> Primes = new ArrayList<>();
	int mod = 1000000007;

	void createPrimeArray() {
		int l = 100005;
		long X[] = new long[l + 1];

		for (int i = 2; i < l; i++) {
			if (X[i] == 0) {
				Primes.add(i);
				for (int j = i * i; j < l && j > 0; j += i)
					X[j] = 1;
			}
		}
	}

	void getPrimeSet(int n, ArrayList<Integer> primeSet) {
		int p, flg = 0;

		for (int i = Primes.size() - 1; i >= 0; i--) {
			p = Primes.get(i);
			if (n % p == 0) {
				primeSet.add(p);
				flg = 1;
			}
		}
		if (flg == 0)
			primeSet.add(n);
	}

	long xorSum(ArrayList<Integer> A) {
		int bits = 0;
		int n = A.size();
		long power = 1;
		// Finding bitwise OR of all elements
		for (int i = 0; i < n; ++i)
			bits |= A.get(i);

		while (n-- > 1)
			power = (power * 2) % mod;

		long ans = (power * bits) % mod;
		return ans;
	}

	public int solve(int[] A) {
		createPrimeArray();

		ArrayList<Integer> primeSet = new ArrayList<>();
		long totalGoodVal = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 1)
				continue;
			primeSet.clear();
			getPrimeSet(A[i], primeSet);
			totalGoodVal = (totalGoodVal + xorSum(primeSet)) % mod;
		}

		return (int) totalGoodVal;
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
		XORPrime xor = new XORPrime();
		System.out.print(xor.solve(A));
		s.close();
	}
}
