package ib.scaler.day70_Apr17;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

	public int[] solve(int[] A) {
		PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minH = new PriorityQueue<>();
		int ans[] = new int[A.length];
		int lcnt = 1, rcnt = 0;

		maxH.add(A[0]);
		ans[0] = A[0];

		for (int i = 1; i < A.length; i++) {
			if (A[i] <= maxH.peek()) {
				maxH.add(A[i]);
				lcnt++;
			} else {
				minH.add(A[i]);
				rcnt++;
			}

			if (lcnt < rcnt) {
				maxH.add(minH.remove());
				rcnt--;
				lcnt++;
			} else if (lcnt - rcnt > 1) {
				minH.add(maxH.remove());
				lcnt--;
				rcnt++;
			}
			ans[i] = maxH.peek();
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(Arrays.toString(new RunningMedian().solve(A)));
		s.close();
	}

}
