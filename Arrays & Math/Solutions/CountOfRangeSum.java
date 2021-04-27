package ib.scaler.day47_Mar24;

import java.util.Arrays;
import java.util.Scanner;

public class CountOfRangeSum {

	int prefix[];

	int mergeSort(int B, int C, int low, int high) {

		if (high - low <= 1)
			return 0;
		int mid = (low + high) / 2, m = mid, n = mid, count = 0;

		count = mergeSort(B, C, low, mid) + mergeSort(B, C, mid, high);
		for (int i = low; i < mid; i++) {
			while (m < high && prefix[m] - prefix[i] < B)
				m++;
			while (n < high && prefix[n] - prefix[i] <= C)
				n++;
			count += n - m;
		}
		Arrays.sort(prefix, low, high);
		return count;
	}

	public int solve(int[] A, int B, int C) {
		prefix = new int[A.length + 1];

		for (int i = 0; i < A.length; i++)
			prefix[i + 1] = prefix[i] + A[i];

		return mergeSort(B, C, 0, A.length + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int B = s.nextInt();
		int C = s.nextInt();

		System.out.println(new CountOfRangeSum().solve(A, B, C));
		s.close();
	}
}
