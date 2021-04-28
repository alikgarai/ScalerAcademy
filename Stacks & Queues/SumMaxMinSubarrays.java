package ib.scaler.day48_Mar25;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SumMaxMinSubarrays {

	int mod = 1000000007;

	public int solve(int[] A, int B) {
		long sum = 0;
		Deque<int[]> minDQ = new LinkedList<>();
		Deque<int[]> maxDQ = new LinkedList<>();

		for (int i = 0; i < B; i++) {
			while (!minDQ.isEmpty() && minDQ.peekLast()[0] > A[i])
				minDQ.removeLast();

			while (!maxDQ.isEmpty() && maxDQ.peekLast()[0] < A[i])
				maxDQ.removeLast();

			minDQ.add(new int[] { A[i], i });
			maxDQ.add(new int[] { A[i], i });
		}

		for (int i = B; i < A.length; i++) {
			sum += (long) minDQ.peekFirst()[0] + (long) maxDQ.peekFirst()[0];

			while (!minDQ.isEmpty() && minDQ.peekLast()[0] > A[i])
				minDQ.removeLast();

			while (!minDQ.isEmpty() && minDQ.peekFirst()[1] <= i - B)
				minDQ.removeFirst();

			while (!maxDQ.isEmpty() && maxDQ.peekLast()[0] < A[i])
				maxDQ.removeLast();

			while (!maxDQ.isEmpty() && maxDQ.peekFirst()[1] <= i - B)
				maxDQ.removeFirst();

			minDQ.add(new int[] { A[i], i });
			maxDQ.add(new int[] { A[i], i });
		}

		sum += (long) minDQ.peekFirst()[0] + (long) maxDQ.peekFirst()[0];
		return Math.floorMod(sum, mod);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int B = s.nextInt();

		System.out.println(new SumMaxMinSubarrays().solve(A, B));
		s.close();
	}

}
