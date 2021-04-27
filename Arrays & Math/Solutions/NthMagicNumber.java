package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class NthMagicNumber {

	public int solve(int A) {

		if (A == 1)
			return 5;
		if (A == 2)
			return 25;

		int a[] = new int[A];
		a[0] = 5;
		a[1] = 25;

		int i = 1;
		int x = 2;
		int p = 25;

		while (x < A) {
			for (int j = 0; j < i; j++) {
				a[x++] = a[i] + a[j];
				if (x == A)
					break;
			}

			if (x == A)
				break;

			p = p * 5;
			a[x] = p;
			i = x++;
		}

		return a[A - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		NthMagicNumber mn = new NthMagicNumber();
		System.out.println(mn.solve(n));
		s.close();
	}
}
