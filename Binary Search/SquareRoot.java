package ib.scaler.day21_Feb19;

import java.util.Scanner;

public class SquareRoot {

	public int sqrt(int A) {

		long s, e, m = 1, val;
		s = 1;
		e = A;
		while (s <= e) {
			m = (s + e) / 2;
			val = m * m;
			if (val == A)
				return (int) m;
			else if (val > A)
				e = m - 1;
			else
				s = m + 1;
		}

		if (m * m > A)
			return (int) (m - 1);
		else
			return (int) m;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		SquareRoot sr = new SquareRoot();
		System.out.println(sr.sqrt(n));
		s.close();
	}

}
