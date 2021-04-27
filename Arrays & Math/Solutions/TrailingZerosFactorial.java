package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class TrailingZerosFactorial {

	public int trailingZeroes(int A) {

		int cnt = 0;
		int val = 5;

		while (val <= A) {
			cnt += A / val;
			val *= 5;
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		TrailingZerosFactorial ln = new TrailingZerosFactorial();
		System.out.println(ln.trailingZeroes(n));
		s.close();
	}

}
