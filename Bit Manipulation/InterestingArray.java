package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class InterestingArray {

	public String solve(int[] A) {
		int sum = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
		}

		if (sum % 2 == 1)
			return "No";
		else
			return "Yes";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		InterestingArray ia = new InterestingArray();
		System.out.println(ia.solve(A));
		s.close();
	}

}
