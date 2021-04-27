package ib.scaler.day29_Mar2;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayWithConsecutiveElements {

	public int solve(int[] A) {
		Arrays.parallelSort(A);
		for (int i = 1; i < A.length; i++) {
			if (A[i] != A[i - 1] + 1)
				return 0;
		}
		return 1;
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
		System.out.print(new ArrayWithConsecutiveElements().solve(A));
		s.close();
	}

}
