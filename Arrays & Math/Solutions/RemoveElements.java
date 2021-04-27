package ib.scaler.day73_Apr21;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RemoveElements {

	public int solve(int[] A) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		long sum = 0;
		int mod = 1000000007;
		int n = A.length;

		for (int i = 0; i < n; i++) {
			sum = (sum + A[i]) % mod;
			maxHeap.add(A[i]);
		}

		long currSum = sum;
		while (n > 0) {
			currSum = Math.floorMod(currSum - maxHeap.remove(), mod);
			sum = Math.floorMod(sum + currSum, mod);
			n--;
		}

		return (int) sum;
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
		System.out.print(new RemoveElements().solve(A));
		s.close();
	}

}
