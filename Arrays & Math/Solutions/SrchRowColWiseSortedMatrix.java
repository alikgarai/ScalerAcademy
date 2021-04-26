package ib.scaler.day07_Feb3;

import java.util.Scanner;

public class SrchRowColWiseSortedMatrix {

	public int solve(int[][] A, int B) {

		int n, m, i, j;
		n = A.length;
		m = A[0].length;

		for (i = 0; i < n; i++) {
			if (B <= A[i][m - 1]) {
				break;
			}
		}

		j = m - 1;

		while (i < n && j >= 0) {
			if (A[i][j] > B)
				j--;
			else if (A[i][j] < B)
				i++;
			else if (j > 0 && A[i][j - 1] == B)
				j--;
			else
				break;
		}

		if (i == n || j < 0)
			return -1;

		return ((i + 1) * 1009 + j + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, m, A[][], B;

		n = s.nextInt();
		m = s.nextInt();
		A = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				A[i][j] = s.nextInt();

		B = s.nextInt();

		SrchRowColWiseSortedMatrix c = new SrchRowColWiseSortedMatrix();
		System.out.println(c.solve(A, B));
		s.close();
	}

}
