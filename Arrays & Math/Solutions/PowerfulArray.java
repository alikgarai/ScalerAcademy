package ib.scaler.day47_Mar24;

import java.util.Scanner;

public class PowerfulArray {

	public int solve(int[] A, int[] B) {

		double p1 = 1, p2 = 1;

		for (int i = 0; i < A.length; i++) {
			p1 += Math.log(A[i]);
			p2 += Math.log(B[i]);
		}
		return p1 >= p2 ? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		System.out.println(new PowerfulArray().solve(A, B));
		s.close();
	}
}
