package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class GridUniquePaths {

	public int calcNcR(int A, int B) {
		int min = (B < A - B) ? B : A - B;
		long prod = 1;

		for (int i = A; i > A - min; i--)
			prod *= i;

		for (int i = min; i > 1; i--)
			prod /= i;

		return (int) prod;
	}

	public int uniquePaths(int A, int B) {
		if (A == 1 || B == 1)
			return 1;

		return calcNcR(A + B - 2, B - 1);

//		Solution 2:
//		if (A == 1 || B == 1)
//			return 1;

//		return uniquePaths(A - 1, B) + uniquePaths(A, B - 1);

//		Solution 3:
//		int grid[][] = new int[A][B];
//
//		for (int i = 0; i < A; i++)
//			grid[i][0] = 1;
//
//		for (int j = 0; j < B; j++)
//			grid[0][j] = 1;
//
//		for (int i = 1; i < A; i++)
//			for (int j = 1; j < B; j++)
//				grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
//
//		return grid[A - 1][B - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		GridUniquePaths gup = new GridUniquePaths();
		System.out.println(gup.uniquePaths(a, b));
		s.close();
	}
}
