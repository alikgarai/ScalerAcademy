package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class LargestCoprimeDivisor {

	public int gcd(int A, int B) {
		if (A == 1 || B == 1)
			return 1;
		if (A == 0 || B == 0)
			return Math.max(A, B);

		if (A > B)
			return gcd(A % B, B);
		if (A < B)
			return gcd(A, B % A);

		if (A == B)
			return A;

		return -1;
	}

	public int cpFact(int A, int B) {
		int m = 1;
		for (int i = 1; i <= Math.sqrt(A); i++) {
			if ((A % i == 0)) {
				if (gcd(i, B) == 1)
					m = Math.max(m, i);
				if (gcd(A / i, B) == 1)
					m = Math.max(m, A / i);
			}
		}
		return m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a, b;

		a = s.nextInt();
		b = s.nextInt();
		LargestCoprimeDivisor lcd = new LargestCoprimeDivisor();
		System.out.println(lcd.cpFact(a, b));
		s.close();
	}

}
