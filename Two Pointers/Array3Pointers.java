package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class Array3Pointers {

	public int minimize(final int[] A, final int[] B, final int[] C) {
		int min = Integer.MAX_VALUE, x = 0, y = 0, z = 0, max;

		while (x < A.length && y < B.length && z < C.length) {
			max = Math.max(Math.abs(A[x] - B[y]), Math.max(Math.abs(B[y] - C[z]), Math.abs(A[x] - C[z])));
			min = Math.min(min, max);

			if (A[x] <= B[y] && A[x] <= C[z])
				x++;

			else if (B[y] <= A[x] && B[y] <= C[z])
				y++;

			else if (C[z] <= B[y] && C[z] <= A[x])
				z++;
		}

		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[], B[], C[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		n = s.nextInt();
		B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = s.nextInt();
		}
		n = s.nextInt();
		C = new int[n];
		for (int i = 0; i < n; i++) {
			C[i] = s.nextInt();
		}
		System.out.print(new Array3Pointers().minimize(A, B, C));
		s.close();
	}

}
