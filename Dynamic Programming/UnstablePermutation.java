package ib.scaler.day114_Jun10;

import java.util.Scanner;

public class UnstablePermutation {

	public int solve(int[] A) {
		int n = A.length;
		boolean isVisited[] = new boolean[n];
		int cnt, maxcnt = 1;

		for (int i = 0; i < n; i++) {
			cnt = 1;
			if (isVisited[i] == true || A[i] == A[A[i] - 1])
				continue;

			int j = A[i] - 1;

			while (j != i) {
				cnt++;
				isVisited[j] = true;
				j = A[j] - 1;
			}
			if ((cnt & (cnt - 1)) != 0)
				return -1;

			maxcnt = Math.max(maxcnt, cnt);
		}
		return (int) (Math.log10(maxcnt) / Math.log10(2));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new UnstablePermutation().solve(A));
		s.close();
	}
}
