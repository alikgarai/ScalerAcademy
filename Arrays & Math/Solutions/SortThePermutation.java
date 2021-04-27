package ib.scaler.day35_Mar8;

import java.util.Scanner;

public class SortThePermutation {

	public int solve(int[] A) {
		int cnt = 0, x, tmp;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == i + 1)
				cnt++;
			else if (A[i] != 0) {
				x = A[i] - 1;
				A[i] = 0;
				cnt++;
				while (x != i) {
					tmp = x;
					x = A[x] - 1;
					A[tmp] = 0;
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		SortThePermutation stp = new SortThePermutation();
		System.out.println(stp.solve(A));
		s.close();
	}

}
