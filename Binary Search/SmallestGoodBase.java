package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class SmallestGoodBase {

	public String solve(String A) {

		long a = Long.parseLong(A);
		int b = (int) (Math.log(a) / Math.log(2));
		long s, e, k, g;

		for (int i = b + 1; i > 2; i--) {
			s = 2;
			e = a - 1;
			while (s <= e) {
				k = (s + e) / 2;
				g = (long) (Math.pow(k, i) - 1) / (k - 1);
				if (g == a)
					return "" + k;
				if (g > a)
					e = k - 1;
				else
					s = k + 1;
			}
		}

		return "" + (a - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.nextLine();

		SmallestGoodBase sgb = new SmallestGoodBase();
		System.out.println(sgb.solve(A));
		s.close();
	}

}
