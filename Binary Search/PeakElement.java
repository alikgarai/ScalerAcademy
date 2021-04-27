package ib.scaler.day17_Feb14;

import java.util.Scanner;

public class PeakElement {

	public int solve(int[] A) {

		int l = A.length;

		if (l == 1)
			return A[0];
		if (l == 2)
			return Math.max(A[0], A[1]);

		int peak = A[0] > A[1] ? A[0] : A[l - 1] > A[l - 2] ? A[l - 1] : 0;

		for (int i = 1; i < l - 1; i++) {
			if (A[i] >= A[i - 1] && A[i] >= A[i + 1]) {
				peak = A[i];
				break;
			}
		}

		return peak;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		PeakElement pe = new PeakElement();
		System.out.println(pe.solve(A));
		s.close();
	}

}
