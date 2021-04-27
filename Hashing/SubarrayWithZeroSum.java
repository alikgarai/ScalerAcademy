package ib.scaler.day36_Mar11;

import java.util.HashSet;
import java.util.Scanner;

public class SubarrayWithZeroSum {

	public int solve(int[] A) {

		HashSet<Long> hs = new HashSet<>();
		Long sum = 0l;
		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			if (hs.contains(sum) || sum == 0)
				return 1;
			hs.add(sum);
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		SubarrayWithZeroSum sa = new SubarrayWithZeroSum();
		System.out.print(sa.solve(A));
		s.close();
	}

}
