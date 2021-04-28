package ib.scaler.day46_Mar23;

import java.util.Scanner;
import java.util.Stack;

public class RedundantBraces {

	public int braces(String A) {
		Stack<Character> S = new Stack<>();
		int l = A.length();
		boolean flg;
		for (int i = 0; i < l; i++) {
			if (A.charAt(i) != ')')
				S.push(A.charAt(i));
			else {
				flg = false;
				while (S.peek() != '(') {
					char c = S.peek();
					if (c == '+' || c == '-' || c == '*' || c == '/') {
						flg = true;
					}
					S.pop();
				}
				if (flg == false) {
					return 1;
				}
				S.pop();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		RedundantBraces rb = new RedundantBraces();
		System.out.println(rb.braces(A));
		s.close();
	}

}
