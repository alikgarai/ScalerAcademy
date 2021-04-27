package ib.scaler.day15_Feb12;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinXOR {

	public int findMinXor(int[] A) {

		Arrays.sort(A);
		int minxor = A[0] ^ A[1];
		for (int i = 1; i < A.length - 1; i++) {
			minxor = minxor > (A[i] ^ A[i + 1]) ? A[i] ^ A[i + 1] : minxor;
		}

		return minxor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		FindMinXOR mx = new FindMinXOR();
		System.out.println(mx.findMinXor(A));
		s.close();
	}

}
