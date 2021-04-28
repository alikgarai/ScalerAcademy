package ib.scaler.day72_Apr20;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShipCompany {

	public int[] solve(int A, int B, int[] C) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		int min = 0, max = 0, i = 0;

		for (i = 0; i < C.length; i++)
			maxHeap.add(C[i]);

		Arrays.parallelSort(C);

		i = 0;
		while (A > 0) {
			max += maxHeap.peek();
			maxHeap.add(maxHeap.remove() - 1);

			if (C[i] == 0)
				i++;

			min += C[i]--;
			A--;
		}
		return new int[] { max, min };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A, B, C[];
		A = s.nextInt();
		B = s.nextInt();
		n = s.nextInt();
		C = new int[n];
		for (int i = 0; i < n; i++) {
			C[i] = s.nextInt();
		}
		System.out.print(Arrays.toString(new ShipCompany().solve(A, B, C)));
		s.close();
	}

}
