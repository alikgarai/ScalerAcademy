package ib.scaler.day72_Apr20;

import java.util.Arrays;
import java.util.Scanner;

public class CandiesInBox {

	public int solve(int[] A) {
		int minSum = Integer.MAX_VALUE, a, sum;
		Arrays.parallelSort(A);

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				a = -1;
				sum = 0;
				for (int k = 0; k < A.length; k++) {
					if (k != i && k != j) {
						if (a == -1)
							a = k;
						else {
							sum += A[k] - A[a];
							a = -1;
						}
					}
				}
				minSum = Math.min(minSum, sum);
			}
		}
		return minSum;
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
		System.out.print(new CandiesInBox().solve(A));
		s.close();
	}

}
