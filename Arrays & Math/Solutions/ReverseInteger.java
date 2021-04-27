package ib.scaler.day13_Feb10;

import java.util.Scanner;

public class ReverseInteger {

	public int reverse(int A) {

		int a = Math.abs(A);
		long sum = 0;
		int val;

		while (a > 0) {
			val = (int) (a % 10);
			sum = sum * 10 + val;
			a /= 10;
		}
		if (A >= 0 && sum <= Integer.MAX_VALUE)
			return (int) sum;
		else if (A < 0 && Math.negateExact(sum) >= Integer.MIN_VALUE)
			return (int) Math.negateExact(sum);
		else
			return 0;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(a));
		s.close();
	}

}
