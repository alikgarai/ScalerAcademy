package ib.scaler.day40_Mar16;

import java.util.Scanner;

public class ReverseTheString {

	public String solve(String A) {
		String ans[] = A.trim().split(" ");
		String S = "";

		for (int i = ans.length - 1; i >= 0; i--)
			S += ans[i] + " ";

		return S.trim();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A;

		A = s.nextLine();

		ReverseTheString rts = new ReverseTheString();
		System.out.print(rts.solve(A));
		s.close();
	}
}
