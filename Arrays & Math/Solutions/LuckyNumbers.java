package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class LuckyNumbers { // Time Complexity: O(nlogn)

	public int solve(int n) {

		int A[] = new int[n + 1];
		int cnt = 0;

		for (int i = 0; i <= n; i++)
			A[i] = 0;

		for (int i = 2; i <= n; i++) {
			if (A[i] != 0)
				continue;
			for (int j = i; j <= n; j += i) {
				A[j]++;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (A[i] == 2) {
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		LuckyNumbers ln = new LuckyNumbers();
		System.out.println(ln.solve(n));
		s.close();
	}
}
