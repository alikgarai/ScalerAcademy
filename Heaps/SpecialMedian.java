package ib.scaler.day70_Apr17;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SpecialMedian {

	PriorityQueue<Long> maxH = new PriorityQueue<>(Collections.reverseOrder());
	PriorityQueue<Long> minH = new PriorityQueue<>();
	long inf = 1000000000000l;

	long findMedian(int lcnt, int rcnt) {
		if (lcnt > rcnt)
			return maxH.peek();
		else {
			long val = minH.peek() + maxH.peek();
			return (Math.floorMod(val, 2)) == 1 ? inf : val / 2;
		}
	}

	public int solve(int[] A) {

		int n = A.length;
		int lcnt = 1, rcnt = 0;

		maxH.add((long) A[0]);

		for (int i = 1; i < n; i++) {
			if (A[i] == findMedian(lcnt, rcnt))
				return 1;
			if (A[i] <= maxH.peek()) {
				maxH.add((long) A[i]);
				lcnt++;
			} else {
				minH.add((long) A[i]);
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
		}

		maxH.clear();
		minH.clear();
		lcnt = 1;
		rcnt = 0;

		maxH.add((long) A[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			if (A[i] == findMedian(lcnt, rcnt))
				return 1;
			if (A[i] <= maxH.peek()) {
				maxH.add((long) A[i]);
				lcnt++;
			} else {
				minH.add((long) A[i]);
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
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new SpecialMedian().solve(A));
		s.close();
	}

}
