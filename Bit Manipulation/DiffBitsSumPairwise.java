package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class DiffBitsSumPairwise {

	public int cntBits(int[] A) {

		int a[] = new int[32];
		int cnt, l = A.length;
		long sum = 0;

		for (int i = 0; i < 32; i++) {
			cnt = 0;
			for (int j = 0; j < l; j++) {
				if (((A[j] >> i) & 1) == 1) {
					cnt++;
				}
			}
			a[i] = cnt;
			sum += (long) (cnt) * (long) (l - cnt);
		}

		return (int) ((sum * 2) % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		DiffBitsSumPairwise df = new DiffBitsSumPairwise();
		System.out.println(df.cntBits(A));
		s.close();
	}

}
