package ib.scaler.day72_Apr20;

import java.util.Arrays;
import java.util.Scanner;

public class MiceToHoles {

	public int mice(int[] A, int[] B) {
		Arrays.parallelSort(A);
		Arrays.parallelSort(B);
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < A.length; i++)
			max = Math.max(max, Math.abs(A[i] - B[i]));

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		System.out.println(new MiceToHoles().mice(A, B));
		s.close();
	}

}
