package ib.scaler.day36_Mar11;

import java.util.HashSet;
import java.util.Scanner;

public class ColorfulNumber {

	public int colorful(int A) {
		HashSet<Integer> hs = new HashSet<>();

		String S = "" + A;
		int l = S.length();
		int prod;

		for (int i = 0; i < l; i++) {
			prod = 1;
			for (int j = i; j < l; j++) {
				prod *= S.charAt(j) - '0';
				if (hs.contains(prod))
					return 0;
				else
					hs.add(prod);
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		ColorfulNumber cn = new ColorfulNumber();
		System.out.println(cn.colorful(n));
		s.close();
	}

}
