package ib.scaler.day47_Mar24;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HireCandidates {

	public int check(int A, int[] B, int m) {
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		long sum = 0;

		for (int i = 0; i < B.length; i++)
			minHeap.add((long) B[i] + (long) (i + 1) * (long) m);

		for (int i = 0; i < m; i++) {
			sum += minHeap.remove();
			if (sum > A)
				break;
		}

		return (int) sum;
	}

	public int[] solve(int A, int[] B) {
		int s, e, m, ans = 1, sum, minCost = 0;

		s = 1;
		e = B.length;
		m = (s + e) / 2;

		while (s <= e) {
			// Check for m students, if returns true discard left else discard right
			sum = check(A, B, m);
			if (sum <= A) {
				s = m + 1;
				ans = m;
				minCost = sum;
			} else
				e = m - 1;

			m = (s + e) / 2;
		}

		return new int[] { ans, minCost };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int n = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();
		System.out.println(Arrays.toString(new HireCandidates().solve(A, B)));
		s.close();
	}

}
