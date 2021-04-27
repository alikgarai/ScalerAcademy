package ib.scaler.day47_Mar24;

import java.util.HashMap;
import java.util.Scanner;

public class ChristmasTree {

	public int solve(int[] A, int[] B) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		long min;
		int val;

		for (int i = 0; i < A.length - 1; i++) {
			min = Integer.MAX_VALUE;

			for (int j = i + 1; j < A.length; j++) {
				if (A[j] > A[i])
					min = Math.min(min, B[i] + B[j]);
			}
			hm.put(i, (int) min);
		}

		min = Long.MAX_VALUE;
		for (int i = 0; i < A.length - 2; i++) {
			if (hm.get(i) != Integer.MAX_VALUE) {
				for (int j = i + 1; j < A.length - 1; j++) {
					val = hm.get(j);
					if (val != Integer.MAX_VALUE && A[j] > A[i])
						min = Math.min(min, B[i] + val);
				}
			}
		}

		return min == Long.MAX_VALUE ? -1 : (int) min;
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
		System.out.println(new ChristmasTree().solve(A, B));
		s.close();
	}

}
