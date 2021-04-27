package ib.scaler.day36_Mar11;

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {

	public int longestConsecutive(final int[] A) {
		HashSet<Integer> H = new HashSet<>();
		for (int i = 0; i < A.length; i++)
			H.add(A[i]);

		int cnt, max = Integer.MIN_VALUE, val;
		for (int i = 0; i < A.length; i++) {
			cnt = 1;
			if (!H.contains(A[i] - 1)) {
				val = A[i] + 1;
				while (H.contains(val)) {
					cnt++;
					val++;
				}
			}
			max = Math.max(max, cnt);
		}

		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		System.out.print(lcs.longestConsecutive(A));
		s.close();
	}

}
