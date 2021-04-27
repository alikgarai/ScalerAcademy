package ib.scaler.day68_Apr15;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BthSmallestPrime {

	class QueueComparator implements Comparator<double[]> {
		public int compare(double[] o1, double[] o2) {
			// TODO Auto-generated method stub
			if (o1[0] < o2[0])
				return -1;
			else if (o1[0] > o2[0])
				return 1;
			return 0;
		}
	}

	public int[] solve(int[] A, int B) {

		int n = A.length;
		PriorityQueue<double[]> pQ = new PriorityQueue<>(new QueueComparator());
		double val = 0;
		double ans[] = new double[3];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				val = (double) A[i] / (double) A[j];
				pQ.add(new double[] { val, A[i], A[j] });
			}
		}

		while (B-- > 0)
			ans = pQ.poll();

		return new int[] { (int) ans[1], (int) ans[2] };
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B = s.nextInt();
		System.out.println(Arrays.toString(new BthSmallestPrime().solve(A, B)));
		s.close();
	}

}
