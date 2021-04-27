package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class ReverseBits {

	public long reverse(long a) {

		long ans = 0;
		int x[] = new int[32];
		int i = 0;

		while (a > 0) {
			x[i++] = (int) (a % 2);
			a /= 2;
		}
		int p = 31;
		for (i = 0; i < 32; i++) {
			System.out.print(x[i]);
			ans += x[i] * Math.pow(2, p--);
		}
		System.out.println();

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		long n = s.nextLong();
		ReverseBits rb = new ReverseBits();
		System.out.println(rb.reverse(n));
		s.close();
	}
}
