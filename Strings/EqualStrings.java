package ib.scaler.day73_Apr21;

import java.util.Scanner;

public class EqualStrings {

	public int solve(String A, String B) {
		if (A.length() != B.length())
			return 0;

		int a[] = new int[26];
		int n = A.length();

		for (int i = 0; i < n; i++)
			a[A.charAt(i) - 'a']++;

		for (int i = 0; i < n; i++)
			a[B.charAt(i) - 'a']++;

		for (int i = 0; i < 26; i++)
			if (a[i] % 2 == 1)
				return 0;

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new EqualStrings().solve(s.next(), s.next()));
		s.close();
	}

}
