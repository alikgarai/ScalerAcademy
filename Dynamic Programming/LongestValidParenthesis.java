package ib.scaler.day83_May4;

import java.util.Scanner;
import java.util.Stack;

public class LongestValidParenthesis {

	public int longestValidParentheses(String A) {
		Stack<Integer> S = new Stack<>();
		int n = A.length();
		int max = 0;

		S.push(-1);

		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == '(') {
				S.add(i);
			} else {
				S.pop();
				if (S.isEmpty())
					S.add(i);
				else
					max = Math.max(max, i - S.peek());
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LongestValidParenthesis().longestValidParentheses(s.next()));
		s.close();
	}

}
