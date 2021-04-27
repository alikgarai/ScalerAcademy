package ib.scaler.day36_Mar11;

import java.util.HashMap;
import java.util.Scanner;

public class Permutations {

	public int solve(String A, String B) {
		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();
		char c;
		int cnt = 0, l1 = A.length(), l2 = B.length();

		for (int i = 0; i < 26; i++) {
			c = (char) ('a' + i);
			hm1.put(c, 0);
			hm2.put(c, 0);
		}

		for (int i = 0; i < l1; i++) {
			c = A.charAt(i);
			hm1.replace(c, hm1.get(c) + 1);
			c = B.charAt(i);
			hm2.replace(c, hm2.get(c) + 1);
		}

		if (hm1.equals(hm2))
			cnt++;

		for (int i = l1; i < l2; i++) {
			c = B.charAt(i - l1);
			hm2.replace(c, hm2.get(c) - 1);
			c = B.charAt(i);
			hm2.replace(c, hm2.get(c) + 1);
			if (hm1.equals(hm2))
				cnt++;
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		String B = s.next();

		System.out.print(new Permutations().solve(A, B));
		s.close();
	}

}
