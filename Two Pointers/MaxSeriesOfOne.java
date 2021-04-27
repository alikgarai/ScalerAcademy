package ib.scaler.day33_Mar6;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSeriesOfOne {

	public int[] maxone(int[] A, int B) {
		int s = 0, e = 0, avbl_zeros = B, window = 0, wStart = 0;

		while (e < A.length) {
			if (A[e] == 1) {
				e++;
			} else if (avbl_zeros > 0) {
				e++;
				avbl_zeros--;
			} else {
				if (window < e - s) {
					wStart = s;
					window = e - s;
				}
				while (s < A.length && A[s] != 0)
					s++;
				s++;
				if (avbl_zeros < B)
					avbl_zeros++;
			}

			if (s > e) {
				while (e < A.length && A[e] != 1)
					e++;
				s = e;
			}
		}

		if (window < e - s) {
			wStart = s;
			window = e - s;
		}

		int ans[] = new int[window];
		for (int i = 0; i < window; i++)
			ans[i] = wStart + i;

		return ans;
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
		int B = s.nextInt();
		System.out.print(Arrays.toString(new MaxSeriesOfOne().maxone(A, B)));
		s.close();
	}

}
