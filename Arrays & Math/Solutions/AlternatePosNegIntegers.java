package ib.scaler.day31_Mar4;

import java.util.ArrayList;
import java.util.Scanner;

public class AlternatePosNegIntegers {

	public ArrayList<Integer> solve(ArrayList<Integer> A) {

		int p, n, l;
		l = A.size();

		for (int i = 0; i < l; i++) {
			if (i % 2 == 0 && A.get(i) >= 0) {
				// Look for negative value at 'n' pos and find new 'n' after adding
				n = i;
				while (A.get(n) >= 0) {
					n++;
					if (n >= l)
						return A;
				}
				A.add(i, A.get(n));
				A.remove(n + 1);

			} else if (i % 2 == 1 && A.get(i) < 0) {
				// Look for positive value at 'p' pos and find new 'p' after adding
				p = i;
				while (A.get(p) < 0) {
					p++;
					if (p >= l)
						return A;
				}
				A.add(i, A.get(p));
				A.remove(p + 1);
			}
		}

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;

		n = s.nextInt();
		ArrayList<Integer> A = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			A.add(s.nextInt());

		AlternatePosNegIntegers apn = new AlternatePosNegIntegers();
		A = apn.solve(A);
		System.out.println(A.toString());

		s.close();
	}
}
