package ib.scaler.day145_Jul17;

import java.util.Scanner;

public class PickFromBothSides {

	public int solve(int[] A, int B) {
		int x, y, sum = 0, maxSum = Integer.MIN_VALUE, n;

		x = 0;
		n = B;
		while (n-- > 0)
			sum += A[x++];

		maxSum = Math.max(maxSum, sum);
		x--;
		y = A.length - 1;

		while (x >= 0) {
			sum += A[y--] - A[x--];
			maxSum = Math.max(maxSum, sum);
		}

		return maxSum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new PickFromBothSides().solve(A, s.nextInt()));
		s.close();
	}

}
