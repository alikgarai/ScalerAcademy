package ib.scaler.day44_Mar20;

import java.util.Scanner;
import java.util.Stack;

public class OrderThem {

	public int solve(int[] A) {
		int C[] = new int[A.length];
		Stack<Integer> B = new Stack<Integer>();

		int rank = 1, k = 0, i = 0;

		while (A[i] != 1)
			B.push(A[i++]);

		while (i < A.length) {
			if (A[i] == rank) {
				C[k++] = rank++;
			} else if (!B.isEmpty() && B.peek() == rank) {
				C[k++] = B.pop();
				i--;
				rank++;
			} else
				B.push(A[i]);
			i++;
		}
		while (!B.isEmpty()) {
			if (B.peek() != rank)
				return 0;
			C[k++] = B.pop();
			rank++;
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		OrderThem ot = new OrderThem();
		System.out.print(ot.solve(A));
		s.close();
	}

}
