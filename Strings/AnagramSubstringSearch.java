package ib.scaler.day42_Mar18;

import java.util.ArrayList;
import java.util.Scanner;

public class AnagramSubstringSearch {

	public boolean isAnagram(String A, String B) {
		int l1 = A.length();
		int l2 = B.length();
		char c = (A.charAt(0) >= 'a' && A.charAt(0) <= 'z') ? 'a' : 'A';

		if (l1 != l2)
			return false;
		else {
			int x[] = new int[26];

			for (int i = 0; i < l1; i++)
				x[A.charAt(i) - c]++;

			for (int i = 0; i < l1; i++)
				x[B.charAt(i) - c]--;

			for (int i = 0; i < 26; i++) {
				if (x[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public int[] solve(String A, String B) {
		int la = A.length();
		int lb = B.length();
		int x, y;
		ArrayList<Integer> ans = new ArrayList<>();

		for (int i = 0; i <= la - lb; i++) {
			if (isAnagram(A.substring(i, i + lb), B)) {
				ans.add(i);
				x = i;
				y = i + lb;
				while (y < la && A.charAt(x) == A.charAt(y)) {
					x++;
					y++;
					ans.add(x);
				}
				if (y >= la)
					break;
				if (B.indexOf(A.charAt(y)) == -1)
					i = y;
				else
					i = A.indexOf(A.charAt(y), x + 1);
			}
		}
		int C[] = new int[ans.size()];
		for (int i = 0; i < ans.size(); i++)
			C[i] = ans.get(i);

		return C;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A, B;
		A = s.nextLine();
		B = s.nextLine();
		AnagramSubstringSearch as = new AnagramSubstringSearch();
		int C[] = as.solve(A, B);
		for (int i = 0; i < C.length; i++)
			System.out.print(C[i] + " ");
		s.close();
	}

}
