package ib.scaler.day46_Mar23;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class RemoveDuplicateLetters {

	public String solve(String A) {
		Stack<Character> S = new Stack<Character>();
		HashMap<Character, Integer> hm = new HashMap<>();
		char c;
		String ans = "";
		int l = A.length();

		for (int i = 0; i < l; i++) {
			c = A.charAt(i);
			if (hm.containsKey(c))
				hm.replace(c, hm.get(c) + 1);
			else
				hm.put(c, 1);
		}

		c = A.charAt(0);
		S.push(c);
		hm.replace(c, hm.get(c) - 1);

		for (int i = 1; i < l; i++) {
			c = A.charAt(i);
			if (S.contains(c)) {
				hm.replace(c, hm.get(c) - 1);
			} else {
				while (c < S.peek() && hm.get(S.peek()) > 0) {
					S.pop();
					if (S.empty())
						break;
				}
				S.push(c);
				hm.replace(c, hm.get(c) - 1);
			}

		}

		while (!S.empty()) {
			ans = S.pop() + ans;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String S = s.next();
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		System.out.print(rdl.solve(S));
		s.close();
	}

}

// nsutwcgpgpxonqbzsvpmjksjminhitsfenbhowixva
// OP: nsucgoqbzpjkmhitfewxva
