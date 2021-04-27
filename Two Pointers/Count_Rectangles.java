package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class Count_Rectangles {

	public int solve(int[] A, int B) {

		long cnt = 0;
		int i, j = A.length - 1;

		for (i = 0; i < A.length; i++) {
			if (j < 0)
				break;
			while ((long) A[i] * (long) A[j] >= B) {
				j--;
				if (j < 0)
					break;
			}
			cnt += j + 1;
		}

		return (int) (cnt % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		int b = s.nextInt();
		Count_Rectangles cr = new Count_Rectangles();
		System.out.print(cr.solve(A, b));
		s.close();
	}
}
