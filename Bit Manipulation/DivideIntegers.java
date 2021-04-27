package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class DivideIntegers {

	public int divide(int A, int B) {

		long sign = ((A < 0) ^ (B < 0)) ? -1 : 1;
		long dividend = Math.abs((long) A);
		long divisor = Math.abs((long) B);
		long q = 0;

		while (dividend >= divisor) {
			dividend -= divisor;
			q++;
		}

		if (q * sign < Integer.MIN_VALUE || q * sign > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		return (int) (q * sign);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		DivideIntegers di = new DivideIntegers();
		System.out.println(di.divide(a, b));
		s.close();
	}
}
