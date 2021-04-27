package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class EnumeratingGCD { // GCD of consecutive numbers is always 1
	public String solve(String A, String B) {

		if (A.equals(B))
			return A;
		return "1";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A, B;

		A = s.nextLine();
		B = s.nextLine();

		EnumeratingGCD c = new EnumeratingGCD();
		System.out.println(c.solve(A, B));

		s.close();
	}

}
