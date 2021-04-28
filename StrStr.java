package ib.scaler.day40_Mar16;

import java.util.Scanner;

public class StrStr {

	public int strStr(final String A, final String B) {

		if (A == "" || B == "")
			return -1;

		int x, y, l1 = A.length(), l2 = B.length();
		boolean flg;

		for (int i = 0; i < l1; i++) {
			if (A.charAt(i) == B.charAt(0)) {
				x = 0;
				y = l2 - 1;
				flg = true;
				while (x <= y) {
					if (i + x >= l1 || i + y >= l1) {
						flg = false;
						break;
					} else if (A.charAt(i + x) != B.charAt(x) || A.charAt(i + y) != B.charAt(y)) {
						flg = false;
						break;
					}
					x++;
					y--;
				}
				if (flg == true)
					return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A, B;

		A = s.nextLine();
		B = s.nextLine();
		StrStr str = new StrStr();
		System.out.print(str.strStr(A, B));
		s.close();
	}

}
