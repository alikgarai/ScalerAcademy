package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class SingleNumber {

	public int singleNumber(final int[] A) {
		if (A.length == 1)
			return A[0];

		int ans = A[0] ^ A[1];

		for (int i = 2; i < A.length; i++) {
			ans ^= A[i];
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		SingleNumber sn = new SingleNumber();
		System.out.println(sn.singleNumber(A));
		s.close();
	}

}
