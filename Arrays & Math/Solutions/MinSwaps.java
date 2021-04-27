package ib.scaler.day29_Mar2;

import java.util.Scanner;

public class MinSwaps {

	public int solve(int[] A, int B) {
		int cnt, min, k = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] <= B)
				k++;
		}
		cnt = 0;
		for (int i = 0; i < k; i++) {
			if (A[i] > B)
				cnt++;
		}
		min = cnt;

		for (int i = k; i < A.length; i++) {
			if (A[i] > B)
				cnt++;
			if (A[i - k] > B)
				cnt--;

			min = Math.min(min, cnt);
		}

		return min;
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
		System.out.print(new MinSwaps().solve(A, B));
		s.close();
	}

}
