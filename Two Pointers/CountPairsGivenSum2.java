package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class CountPairsGivenSum2 {

	public int solve(int[] A, int B) {
		int i = 0, j = A.length - 1, sum, cnt1, cnt2;
		long n, cnt = 0;
		while (i < j) {
			sum = A[i] + A[j];
			if (sum == B) {
				if (A[i] == A[j]) {
					n = j - i + 1;
					cnt += (n * (n - 1)) / 2;
					break;
				} else {
					cnt1 = 1;
					cnt2 = 1;
					while (A[i + 1] == A[i] && i + 1 < j) {
						i++;
						cnt1++;
					}
					while (A[j - 1] == A[j] && i < j - 1) {
						j--;
						cnt2++;
					}
					cnt += cnt1 * cnt2;
					i++;
				}
			} else if (sum > B)
				j--;
			else
				i++;
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
		CountPairsGivenSum2 cp = new CountPairsGivenSum2();
		System.out.print(cp.solve(A, b));
		s.close();
	}

}
