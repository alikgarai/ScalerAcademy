package ib.scaler.day42_Mar18;

import java.util.Scanner;

public class SameFormatString {

	public int solve(final String A, final String B) {
		int i, j, l1, l2;
		char x;
		i = 0;
		j = 0;
		l1 = A.length();
		l2 = B.length();

		if (l2 < l1)
			return 0;

		while (i < l1) {
			x = A.charAt(i);
			if (j == l2 || B.charAt(j) != x) {
				return 0;
			} else {
				while (j < l2 && B.charAt(j) == x)
					j++;
				i++;
			}
		}
		if (i == l1 && j == l2)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A, B;

		A = s.nextLine();
		B = s.nextLine();
		SameFormatString sfs = new SameFormatString();
		System.out.println(sfs.solve(A, B));
		s.close();
	}

}
