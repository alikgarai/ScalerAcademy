package ib.scaler.day46_Mar23;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class KthCharacter {

	public String solve(String A, int B) {
		Stack<Long> S = new Stack<>();
		HashMap<Long, Character> hm = new HashMap<>();

		long n, l = 0;
		char c;
		for (int i = 0; i < A.length(); i++) {
			c = A.charAt(i);
			if (c >= 'a' && c <= 'z') {
				l++;
				S.push(l);
				hm.put(l, c);
			} else {
				n = 0;
				while (c >= '0' && c <= '9') {
					n = n * 10 + (c - '0');
					i++;
					if (i >= A.length())
						break;
					c = A.charAt(i);
				}
				i--;
				l *= n;
			}
		}
		l = B;
		while (l > 0) {
			while (l < S.peek()) {
				S.pop();
			}
			n = S.pop();
			l = l % n;
			if (l == 0)
				return "" + hm.get(n);
		}
		return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		int B = s.nextInt();

		KthCharacter kc = new KthCharacter();
		System.out.print(kc.solve(A, B));
		s.close();
	}

}
