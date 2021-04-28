package ib.scaler.day48_Mar25;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNegInAllSubArrays {

//	class Nod {
//		int x;
//		int val;
//
//		Nod(int x, int val) {
//			this.x = x;
//			this.val = val;
//		}
//
//	}

	public int[] solve(int[] A, int B) {

		Queue<Integer> q = new LinkedList<>();
		int ans[] = new int[A.length - B + 1];

		for (int i = 0; i < B; i++) {
			if (A[i] < 0)
				q.add(A[i]);
		}
		for (int i = B; i < A.length; i++) {
			if (!q.isEmpty())
				ans[i - B] = q.peek();
			if (A[i - B] < 0)
				q.remove();
			if (A[i] < 0)
				q.add(A[i]);
		}
		if (!q.isEmpty())
			ans[A.length - B] = q.peek();

		return ans;

//		Queue<Nod> q = new LinkedList<>();
//		int ans[] = new int[A.length + 1 - B];
//		int x;
//
//		for (int i = 0; i < A.length; i++) {
//			if (A[i] < 0) {
//				q.add(new Nod(i, A[i]));
//			}
//		}
//		for (int i = 0; i <= A.length - B; i++) {
//
//			if (q.isEmpty())
//				return ans;
//
//			x = q.peek().x;
//
//			while (x < i) {
//				q.remove();
//				if (q.isEmpty())
//					return ans;
//				x = q.peek().x;
//			}
//
//			if (x < i + B) {
//				ans[i] = q.peek().val;
//			}
//		}
//		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B = s.nextInt();
		System.out.println(Arrays.toString(new FirstNegInAllSubArrays().solve(A, B)));
		s.close();
	}

}
