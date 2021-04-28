package ib.scaler.day42_Mar18;

import java.util.Scanner;

public class CountAndSay {

	public String countAndSay(int A) {
		String S = "1";
		String tmp;
		int cnt;

		if (A == 1)
			return S;

		while (A-- > 1) {
			tmp = "";
			for (int i = 0; i < S.length(); i++) {
				char c = S.charAt(i);
				cnt = 0;
				while (i < S.length() && S.charAt(i) == c) {
					cnt++;
					i++;
				}
				i--;
				tmp += "" + cnt + c;
			}
			S = tmp;
		}

		return S;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		CountAndSay cas = new CountAndSay();
		System.out.print(cas.countAndSay(A));
		s.close();
	}

}
