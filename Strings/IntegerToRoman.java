package ib.scaler.day40_Mar16;

import java.util.Scanner;

public class IntegerToRoman {

	public String intToRoman(int A) {

		int B[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
		String S[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int i = 12;
		String ans = "";

		while (i >= 0) {
			if (A >= B[i]) {
				ans += S[i];
				A -= B[i];
			} else
				i--;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A;

		A = s.nextInt();
		IntegerToRoman itr = new IntegerToRoman();
		System.out.print(itr.intToRoman(A));
		s.close();
	}
}
