package ib.scaler.day40_Mar16;

import java.util.Scanner;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] A) {

		String ans = "";
		char x;
		int i = 0, l = A[0].length(), k;

		while (i < l) {
			x = A[0].charAt(i);
			for (k = 1; k < A.length; k++) {
				if (i >= A[k].length() || A[k].charAt(i) != x) {
					break;
				}
			}
			if (k == A.length) {
				ans += x;
			} else {
				return ans;
			}
			i++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n;
		n = s.nextInt();
		String A[] = new String[n];
		for (int i = 0; i < n; i++)
			A[i] = s.next();

		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(A));
		s.close();
	}

}
