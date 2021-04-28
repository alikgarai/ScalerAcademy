package ib.scaler.day59_Apr6;

import java.util.Scanner;

public class CheckBSTOneChild {

	public String solve(int[] A) {
		int i, min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

		if (A[1] > A[0])
			min = A[0];
		else
			max = A[0];

		i = 2;

		while (i < A.length) {
			if (A[i] > min && A[i] <= max) {
				if (A[i] > A[i - 1])
					min = A[i - 1];
				else
					max = A[i - 1];
			} else
				return "NO";
			i++;
		}

		return "YES";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new CheckBSTOneChild().solve(A));
		s.close();
	}

}
