package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class CountPairsGivenSum {

	public int solve(int[] A, int B) {
		int i = 0, j = A.length - 1, sum, cnt = 0;

		while (i < j) {
			sum = A[i] + A[j];
			if (sum == B) {
				cnt++;
				i++;
			} else if (sum > B)
				j--;
			else
				i++;
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
		int b = s.nextInt();
		CountPairsGivenSum cp = new CountPairsGivenSum();
		System.out.print(cp.solve(A, b));
		s.close();
	}

}
