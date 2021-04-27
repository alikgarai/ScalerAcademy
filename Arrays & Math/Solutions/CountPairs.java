package ib.scaler.day24_Feb25;

import java.util.Scanner;

public class CountPairs {

	public int solve(int[] A, int B) {
		long cnt = 0;
		int l = A.length;
		int freq[] = new int[B];

		for (int i = 0; i < l; i++)
			freq[A[i] % B]++;

		cnt += ((long) freq[0] * (long) (freq[0] - 1)) / 2;

		for (int i = 1; i <= B / 2; i++) {
			if (i == (B - i))
				break;
			cnt += (long) freq[i] * (long) freq[B - i];
		}
		if (B % 2 == 0) {
			cnt += ((long) freq[B / 2] * (long) (freq[B / 2] - 1)) / 2;
		}

		return (int) (cnt % 1000000007);
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
		CountPairs cp = new CountPairs();
		System.out.print(cp.solve(A, b));
		s.close();
	}
}
