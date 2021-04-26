package ib.scaler.day07_Feb3;

import java.util.Scanner;

public class FizzBuzz {

	public String[] fizzBuzz(int A) {

		String[] s = new String[A];

		for (int i = 1; i <= A; i++) {
			if (i % 15 == 0) {
				s[i - 1] = "FizzBuzz";
			} else if (i % 3 == 0) {
				s[i - 1] = "Fizz";
			} else if (i % 5 == 0) {
				s[i - 1] = "Buzz";
			} else {
				s[i - 1] = Integer.toString(i);
			}
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;
		String A[];

		n = s.nextInt();
		A = new String[n];

		FizzBuzz c = new FizzBuzz();
		A = c.fizzBuzz(n);
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}
}
