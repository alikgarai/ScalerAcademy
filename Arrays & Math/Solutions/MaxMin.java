package ib.scaler.day29_Mar2;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

	public int solve(int[] A, int B) {

		Arrays.sort(A);
		int l = A.length;

		return A[l - B] - A[B - 1];
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
		int b = s.nextInt();

		MaxMin mm = new MaxMin();
		System.out.println(mm.solve(A, b));
		s.close();
	}

}
