package ib.scaler.day23_Feb24;

import java.util.Arrays;
import java.util.Scanner;

public class Permutations {

	public int[][] permute(int[] A) {
		Arrays.sort(A);
		int n = A.length;
		int x = factorial(n);
		int B[][] = new int[x][n];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < n; j++) {
				B[i][j] = A[j];
			}
			A = nextPermutation(A);
		}
		return B;
	}

	public static int[] nextPermutation(int[] A) {
		int l = A.length;
		int k, tmp;

		for (k = l - 2; k >= 0; k--) {
			if (A[k] < A[k + 1]) {
				break;
			}
		}

		if (k == -1) {
			Arrays.sort(A);
			return A;
		}

		for (int i = l - 1; i >= 0; i--) {
			if (A[i] > A[k]) {
				tmp = A[i];
				A[i] = A[k];
				A[k] = tmp;
				break;
			}
		}
		Arrays.sort(A, k + 1, l);

		return A;
	}

	public static int factorial(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial(n - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		Permutations p = new Permutations();
		int x = factorial(n);
		int B[][] = new int[x][n];
		B = p.permute(A);

		for (int i = 0; i < x; i++) {
			System.out.print("[" + B[i][0]);
			for (int j = 1; j < n; j++) {
				System.out.print(", " + B[i][j]);
			}
			System.out.println("]");
		}
		s.close();
	}

}
