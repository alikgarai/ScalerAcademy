package ib.scaler.day40_Mar16;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {

	public int romanToInt(String A) {
		String s1, s2;
		int val = 0;
		int l = A.length();

		HashMap<String, Integer> H = new HashMap<>();
		H.put("I", 1);
		H.put("IV", 4);
		H.put("V", 5);
		H.put("IX", 9);
		H.put("X", 10);
		H.put("XL", 40);
		H.put("L", 50);
		H.put("XC", 90);
		H.put("C", 100);
		H.put("CD", 400);
		H.put("D", 500);
		H.put("CM", 900);
		H.put("M", 1000);

		int i;
		for (i = 0; i < l - 1; i++) {
			s1 = "" + A.charAt(i);
			s2 = "" + A.charAt(i + 1);

			if (H.get(s1) < H.get(s2)) {
				val += H.get(s1 + s2);
				i++;
			} else {
				val += H.get(s1);
			}
		}
		if (i == l - 1) {
			val += H.get("" + A.charAt(i));
		}

		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A;

		A = s.nextLine();
		RomanToInteger rti = new RomanToInteger();
		System.out.print(rti.romanToInt(A));
		s.close();
	}

}
