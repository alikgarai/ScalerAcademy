package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class ComputeNcR {

	public int solve(int A, int B, int C) {
		int min = (B < A - B) ? B : A - B;
		long nmod = 1, dmod = 1;

		for (int i = A; i > A - min; i--)
			nmod = (nmod * i) % C;

		for (int i = min; i > 1; i--)
			dmod = (dmod * i) % C;

		long x = 1;
		int p = C - 2;

		while (p > 0) {
			if (p % 2 == 1) {
				x = (x * dmod) % C;
			}
			dmod = (dmod * dmod) % C;
			p /= 2;
		}

		return (int) ((nmod * x) % C);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		ComputeNcR ncr = new ComputeNcR();
		System.out.println(ncr.solve(a, b, c));
		s.close();
	}
}
