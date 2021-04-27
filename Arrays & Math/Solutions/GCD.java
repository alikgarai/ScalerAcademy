package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class GCD {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int B, A;

		A = s.nextInt();
		B = s.nextInt();

		GCD c = new GCD();
		System.out.println(c.gcd(A, B));

		s.close();
	}

}
