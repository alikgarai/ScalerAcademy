package ib.scaler.day42_Mar18;

import java.util.Scanner;

public class DivisibilityBy8 {

	public int solve(String A) {
		int l = A.length();
		int val = 0;

		if (l >= 3) {
			for (int i = l - 3; i < l; i++)
				val = val * 10 + (int) A.charAt(i);
		} else
			val = Integer.parseInt(A);

		if (val % 8 == 0)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A;
		A = s.nextLine();
		DivisibilityBy8 div8 = new DivisibilityBy8();
		System.out.println(div8.solve(A));
		s.close();
	}
}
