package ib.scaler.day07_Feb3;

import java.util.Scanner;

public class MaxChunksSorted2 {

	public int solve(int[] A) {

//		Create suffix min array
		int smin[], count, l, max;
		l = A.length;
		smin = new int[l];
		max = Integer.MIN_VALUE;
		smin[l - 1] = A[l - 1];

		for (int i = l - 2; i >= 0; i--)
			smin[i] = Math.min(smin[i + 1], A[i]);

		count = 1;

		for (int i = 1; i < l; i++) {
			max = Math.max(max, A[i - 1]);
			if (smin[i] >= max)
				count++;
		}

		return count;
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

		MaxChunksSorted2 c = new MaxChunksSorted2();
		System.out.println(c.solve(A));
		s.close();
	}
}
