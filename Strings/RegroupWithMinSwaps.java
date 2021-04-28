package ib.scaler.day42_Mar18;

import java.util.Scanner;

public class RegroupWithMinSwaps {

	public int solve(final String A) {
		int cnt_l = 0, cnt_r = 0, cnt = 0, i = 0, l = A.length();

		// 1's on left
		while (i < l) {
			while (i < l && A.charAt(i) == '1') {
				i++;
				cnt_l += cnt;
			}
			while (i < l && A.charAt(i) == '0') {
				i++;
				cnt++;
			}
		}

		// 1's on right
		i = 0;
		cnt = 0;
		while (i < l) {
			while (i < l && A.charAt(i) == '1') {
				i++;
				cnt++;
			}
			while (i < l && A.charAt(i) == '0') {
				i++;
				cnt_r += cnt;
			}
		}
		return Math.min(cnt_l, cnt_r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		RegroupWithMinSwaps rg = new RegroupWithMinSwaps();
		System.out.println(rg.solve(A));
		s.close();
	}

}
