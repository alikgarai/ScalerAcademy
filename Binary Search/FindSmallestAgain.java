package ib.scaler.day24_Feb25;

import java.util.Arrays;
import java.util.Scanner;

public class FindSmallestAgain {

	public int calcNcR(int A, int B) {
		int min = (B < A - B) ? B : A - B;
		long prod = 1;

		for (int i = A; i > A - min; i--)
			prod *= i;

		for (int i = min; i > 1; i--)
			prod /= i;

		return (int) prod;
	}

	public int solve(int[] A, int B) {

		int l = A.length;
		if (l == 3)
			return A[0] + A[1] + A[2];

		int n = calcNcR(l, 3);
		int C[] = new int[n];
		int x = 0;

		for (int i = 0; i < l - 2; i++) {
			for (int j = i + 1; j < l - 1; j++) {
				for (int k = j + 1; k < l; k++) {
					C[x++] = A[i] + A[j] + A[k];
				}
			}
		}

		Arrays.sort(C);

		return C[B - 1];
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
		FindSmallestAgain fsa = new FindSmallestAgain();
		System.out.print(fsa.solve(A, b));
		s.close();
	}
}
