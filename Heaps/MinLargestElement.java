package ib.scaler.day70_Apr17;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MinLargestElement {

	class QueueComparator implements Comparator<int[]> {
		public int compare(int[] o1, int[] o2) {
			return (o1[0] + o1[1]) - (o2[0] + o2[1]);
		}
	}

	public int solve(int[] A, int B) {

		PriorityQueue<int[]> pQ = new PriorityQueue<>(new QueueComparator());
		int x[];

		for (int i = 0; i < A.length; i++)
			pQ.add(new int[] { A[i], A[i] });

		for (int i = 0; i < B; i++) {
			x = pQ.remove();
			pQ.add(new int[] { x[0] + x[1], x[1] });
		}

		int max = pQ.remove()[0];
		while (pQ.size() > 0) {
			max = Math.max(max, pQ.remove()[0]);
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
		int B = s.nextInt();
		System.out.println(new MinLargestElement().solve(A, B));
		s.close();
	}

}
