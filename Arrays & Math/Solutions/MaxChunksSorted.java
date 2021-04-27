package ib.scaler.day31_Mar4;

import java.util.Scanner;

public class MaxChunksSorted {

	public int solve(int[] A) {
		int chunks = 0;
		int max = A[0];
		for (int i = 0; i < A.length; i++) {
			max = Math.max(max, A[i]);
			if (max == i)
				chunks++;
		}
		return chunks;
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

		MaxChunksSorted c = new MaxChunksSorted();
		System.out.println(c.solve(A));
		s.close();
	}
}
