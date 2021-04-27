package ib.scaler.day09_Feb5;

import java.util.Scanner;

public class RepeatedSubtraction {
	public int getFinal(int A, int B) {

		while (A != 0 && B != 0 && A != B) {
			if (A > B) {
				A = (A % B == 0) ? B : A % B;
			} else {
				B = (B % A == 0) ? A : B % A;
			}
		}
		return A + B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A, B;

		A = s.nextInt();
		B = s.nextInt();

		RepeatedSubtraction c = new RepeatedSubtraction();
		System.out.println(c.getFinal(A, B));

		s.close();
	}

}
