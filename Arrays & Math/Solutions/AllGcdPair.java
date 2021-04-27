package ib.scaler.day13_Feb10;

import java.util.Arrays;
import java.util.Scanner;

public class AllGcdPair {

	public int gcd(int A, int B) {
		if (A == 1 || B == 1)
			return 1;
		if (A == 0 || B == 0)
			return Math.max(A, B);

		if (A > B)
			return gcd(A % B, B);
		if (A < B)
			return gcd(A, B % A);

		if (A == B)
			return A;

		return -1;
	}

	public int[] solve(int[] A) {
		Arrays.sort(A);
		int n = A.length;
		int x = (int) Math.sqrt(n);

		int freq[] = new int[A[n - 1] + 1];
		for (int i = 0; i < n; i++)
			freq[A[i]]++;

		int B[] = new int[x];
		int l = 0, gcd;

		for (int i = n - 1; i >= 0; i--) {
			if (freq[A[i]] != 0) {
				B[l] = A[i];
				freq[A[i]]--;
				for (int j = 0; j < l; j++) {
					gcd = gcd(B[l], B[j]);
					freq[gcd] -= 2;
				}
				l++;
			}
		}

		return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		AllGcdPair acp = new AllGcdPair();
		A = acp.solve(A);

		for (int i = 0; i < A.length; i++)
			System.out.print(A[i] + " ");

		s.close();
	}
}
