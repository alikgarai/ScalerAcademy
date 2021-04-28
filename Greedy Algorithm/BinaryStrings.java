package ib.scaler.day72_Apr20;

import java.util.Scanner;

public class BinaryStrings {

	public int solve(String A, int B) {
		int cnt = 0;
		int n = A.length();
		int X[] = new int[n];

		for (int i = 0; i < n; i++)
			X[i] = A.charAt(i) - '0';

		for (int i = 0; i <= n - B; i++) {
			if (X[i] == 0) {
				cnt++;
				for (int j = i; j < i + B; j++)
					X[j] = X[j] == 0 ? 1 : 0;
			}
		}
		for (int i = n - B + 1; i < n; i++)
			if (X[i] == 0)
				return -1;

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print(new BinaryStrings().solve(s.next(), s.nextInt()));
		s.close();
	}

}
