package ib.scaler.day27_Feb28;

import java.util.Scanner;

public class Sixlets {

	int count = 0;

	void subsequences(int[] A, int start, int sum, int cnt, int B) {
		if (cnt == B && sum <= 1000) {
			count++;
			return;
		}

		for (int i = start; i < A.length && (cnt < B) && (A.length - i + cnt >= B); i++)
			subsequences(A, i + 1, sum + A[i], cnt + 1, B);
	}

	public int solve(int[] A, int B) {
		subsequences(A, 0, 0, 0, B);
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		System.out.println(new Sixlets().solve(A, s.nextInt()));
		s.close();
	}

}
