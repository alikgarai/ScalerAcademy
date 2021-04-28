package ib.scaler.day44_Mar20;

import java.util.Scanner;
import java.util.Stack;

public class SortArrayUsingStack {

	public void sortInserted(Stack<Integer> S, int x) {
		int temp;
		if (S.isEmpty() || S.peek() >= x) {
			S.push(x);
		} else {
			temp = S.pop();
			sortInserted(S, x);
			S.push(temp);
		}
	}

	public int[] solve(int[] A) {

		Stack<Integer> S = new Stack<>();
		S.push(A[0]);
		for (int i = 1; i < A.length; i++) {
			sortInserted(S, A[i]);
		}

		for (int i = 0; i < A.length; i++)
			A[i] = S.pop();

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		SortArrayUsingStack sa = new SortArrayUsingStack();
		A = sa.solve(A);
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
		s.close();
	}

}
