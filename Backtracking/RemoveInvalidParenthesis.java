package ib.scaler.day27_Feb28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class RemoveInvalidParenthesis {

	ArrayList<String> ans = new ArrayList<>();
	HashSet<String> set = new HashSet<>();
	int len;

	boolean isValid(String A) {
		Stack<Character> S = new Stack<>();
		int n = A.length();

		for (int i = 0; i < n; i++) {
			char c = A.charAt(i);

			if (c == '(')
				S.push('(');

			else if (c == ')') {
				if (S.isEmpty())
					return false;
				S.pop();
			}
		}
		if (!S.isEmpty())
			return false;
		return true;
	}

	void check(String A, int start, String curr) {
		int l = curr.length();

		if (l == len && !set.contains(curr) && isValid(curr)) {
			ans.add(curr);
			set.add(curr);
			return;
		}

		int n = A.length();
		for (int i = start; i < n && (n - i + l >= len); i++)
			check(A, i + 1, curr + A.charAt(i));
	}

	public ArrayList<String> solve(String A) {
		Stack<Character> S = new Stack<>();
		int cnt = 0, n = A.length();

		for (int i = 0; i < n; i++) {
			char c = A.charAt(i);

			if (c == '(')
				S.push('(');

			else if (c == ')') {
				if (S.isEmpty()) {
					cnt++;
					continue;
				}
				S.pop();
			}
		}
		while (!S.isEmpty()) {
			cnt++;
			S.pop();
		}

		if (cnt == n) {
			ans.add("");
			return ans;
		}

		len = n - cnt;
		check(A, 0, "");

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new RemoveInvalidParenthesis().solve(s.next()));
		s.close();
	}

}
