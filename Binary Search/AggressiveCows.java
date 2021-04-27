package ib.scaler.day21_Feb19;

import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

	public boolean check(int[] A, int B, int m) {
		int c = 1;
		int x = 0;

		for (int i = 1; i < A.length; i++) {
			if (A[i] - A[x] >= m) {
				c++;
				x = i;
				if (c >= B)
					return true;
			}
		}

		return false;
	}

	public int solve(int[] A, int B) {
		Arrays.sort(A);
		int l = A.length;
		int s, e, m, ans = 1;

		s = 1;
		e = A[l - 1];
		m = (s + e) / 2;
		while (s <= e) {
			// Check for m, if returns true discard left else discard right
			if (check(A, B, m) == true) {
				s = m + 1;
				ans = m;
			} else {
				e = m - 1;
			}
			m = (s + e) / 2;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		int b = s.nextInt();

		AggressiveCows ac = new AggressiveCows();
		System.out.println(ac.solve(A, b));
		s.close();
	}

}
