package ib.scaler.day72_Apr20;

import java.util.Scanner;

public class DistributeCandy {

	public int candy(int[] A) {

		int ans[] = new int[A.length];
		ans[0] = 1;

		for (int i = 1; i < A.length; i++) {
			if (A[i] > A[i - 1])
				ans[i] = ans[i - 1] + 1;
			else
				ans[i] = 1;
		}
		int sum = ans[A.length - 1];
		for (int i = A.length - 2; i >= 0; i--) {
			int val = 1;
			if (A[i] > A[i + 1])
				val = ans[i + 1] + 1;
			sum += Math.max(val, ans[i]);
			ans[i] = val;
		}
		return sum;
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
		System.out.print(new DistributeCandy().candy(A));
		s.close();
	}

}
