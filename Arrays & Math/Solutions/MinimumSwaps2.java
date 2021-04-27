package ib.scaler.day31_Mar4;

import java.util.Scanner;

public class MinimumSwaps2 {

	public int solve(int[] A) {
		int l = A.length;
		int tmp, cnt = 0;

		for (int i = 0; i < l; i++) {
			if (A[i] != i) {
				// Find i
				for (int j = i + 1; j < l; j++) {
					if (A[j] == i) {
						tmp = A[i];
						A[i] = A[j];
						A[j] = tmp;
						cnt++;
						break;
					}
				}
			}

		}
		return cnt;
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

		MinimumSwaps2 ms = new MinimumSwaps2();
		System.out.println(ms.solve(A));
		s.close();
	}
}
