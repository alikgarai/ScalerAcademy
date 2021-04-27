package ib.scaler.day31_Mar4;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumMinimumLogic {

	public int[] solve(int[] A) {
		Arrays.parallelSort(A);
		long max = 0, min = 0;
		int n = A.length, mod = 1000000007;

		for (int i = 0; i < n; i += 2)
			min = Math.floorMod(min + Math.abs(A[i] - A[i + 1]), mod);

		for (int i = 0; i < n / 2; i++)
			max = Math.floorMod(max + Math.abs(A[i] - A[n - i - 1]), mod);

		return new int[] { (int) max, (int) min };
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
		System.out.print(Arrays.toString(new MaximumMinimumLogic().solve(A)));
		s.close();
	}

}
