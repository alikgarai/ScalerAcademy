package ib.scaler.day40_Mar16;

import java.math.BigInteger;
import java.util.Scanner;

public class CompareVersionNumber {

	public int compareVersion(String A, String B) {

		String a[] = A.replace('.', ':').split(":");
		String b[] = B.replace('.', ':').split(":");
		int i;
		int l = Math.min(a.length, b.length);
		BigInteger a1, b1;

		for (i = 0; i < l; i++) {
			a1 = new BigInteger(a[i]);
			b1 = new BigInteger(b[i]);
			if (a1.compareTo(b1) > 0)
				return 1;
			else if (a1.compareTo(b1) < 0)
				return -1;
		}
		if (a.length > b.length) {
			while (i < a.length) {
				a1 = new BigInteger(a[i]);
				if (a1.compareTo(BigInteger.ZERO) > 0) {
					return 1;
				}
				i++;
			}
			return 0;
		}

		else if (a.length < b.length) {
			while (i < b.length) {
				b1 = new BigInteger(b[i]);
				if (b1.compareTo(BigInteger.ZERO) > 0) {
					return -1;
				}
				i++;
			}
			return 0;
		} else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A, B;

		A = s.nextLine();
		B = s.nextLine();

		CompareVersionNumber cvn = new CompareVersionNumber();
		System.out.print(cvn.compareVersion(A, B));
		s.close();
	}
}
