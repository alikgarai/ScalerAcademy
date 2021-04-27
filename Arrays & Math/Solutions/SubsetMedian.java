package ib.scaler.day114_Jun10;

import java.util.Scanner;

public class SubsetMedian {

	public int solve(int[] A) {
		int sum = 0;

		for (int i = 0; i < A.length; i++)
			sum += A[i];

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new PartitionSort().solve(A));
		s.close();
	}

}
