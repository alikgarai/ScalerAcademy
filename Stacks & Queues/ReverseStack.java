package ib.scaler.day46_Mar23;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStack {

	public void reverse(int[] A, int index) {
		if (index == A.length - 1) {
			A[0] = A[index];
		} else {
			int tmp = A[index];
			reverse(A, index + 1);
			A[A.length - index - 1] = tmp;
		}
	}

	public int[] solve(int[] A) {
		reverse(A, 0);
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		ReverseStack rs = new ReverseStack();
		System.out.print(Arrays.toString(rs.solve(A)));
		s.close();
	}

}
