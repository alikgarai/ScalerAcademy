package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class ClosestPairTwoArrays {

	public int[] solve(int[] A, int[] B, int C) {
		int ans[] = new int[2];

		int i, j, d, sum, l1, l2, min;
		l1 = A.length;
		l2 = B.length;
		min = Integer.MAX_VALUE;

		i = 0;
		j = l2 - 1;

		while (i < l1 && j >= 0) {
			sum = A[i] + B[j];
			d = Math.abs(sum - C);
			if (d == 0) {
				ans[0] = A[i];
				ans[1] = B[j];
				return ans;
			}
			if (d < min || (d == min && (A[i] < ans[0] || (A[i] == ans[0] && B[j] < ans[1])))) {
				min = d;
				ans[0] = A[i];
				ans[1] = B[j];
			}
			if (sum <= C)
				i++;
			else
				j--;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[], B[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		n = s.nextInt();
		B = new int[n];
		for (int i = 0; i < n; i++) {
			B[i] = s.nextInt();
		}

		int C = s.nextInt();
		ClosestPairTwoArrays cp = new ClosestPairTwoArrays();
		A = cp.solve(A, B, C);
		System.out.println("[" + A[0] + ", " + A[1] + "]");
		s.close();
	}

}
