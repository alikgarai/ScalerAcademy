package ib.scaler.day40_Mar16;

import java.util.Scanner;

public class MinCharsToPallindrome {

	public boolean isPallindrome(String A, int s, int e) {
		while (s < e) {
			if (A.charAt(s) != A.charAt(e))
				return false;
			else {
				s++;
				e--;
			}
		}

		return true;
	}

	public int solve(String A) {
		int s = 0, e = A.length() - 1;

		// find max pallindrome from s
		while (s < e) {
			if (A.charAt(s) == A.charAt(e) && isPallindrome(A, s, e)) {
				return A.length() - e - 1;
			} else
				e--;
		}

		return A.length() - e - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A;

		A = s.nextLine();
		MinCharsToPallindrome mc = new MinCharsToPallindrome();
		System.out.print(mc.solve(A));
		s.close();
	}
}
