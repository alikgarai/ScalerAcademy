package ib.scaler.day07_Feb3;

import java.util.Scanner;

public class RearrangeTheArray {

	public int[] solve(int[] A) {
		int B[] = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			B[A[i]] = i;
		}
		return B;
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

		RearrangeTheArray c = new RearrangeTheArray();
		A = c.solve(A);
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}
}