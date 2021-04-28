package ib.scaler.day48_Mar25;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FirstNonRepeatingChar {

	public String solve(String A) {
		Queue<Character> Q = new LinkedList<>();
		int X[] = new int[26];
		int l = A.length();
		char ans[] = new char[l];
		char c;

		for (int i = 0; i < l; i++) {
			c = A.charAt(i);
			X[c - 'a']++;
			if (X[c - 'a'] == 1)
				Q.add(c);

			while (!Q.isEmpty() && X[Q.peek() - 'a'] > 1)
				Q.remove();

			ans[i] = Q.isEmpty() ? '#' : Q.peek();
		}
		return new String(ans);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String S = s.next();
		System.out.println(new FirstNonRepeatingChar().solve(S));
		s.close();
	}

}
