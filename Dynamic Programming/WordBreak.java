package ib.scaler.day108_Jun3;

import java.util.HashSet;
import java.util.Scanner;

public class WordBreak {

	public int wordBreak(String A, String[] B) {
		int n = A.length();
		int maxl = 0;
		boolean isValid[] = new boolean[n + 1];
		HashSet<String> set = new HashSet<>();

		for (int i = 0; i < B.length; i++) {
			set.add(B[i]);
			maxl = Math.max(maxl, B[i].length());
		}

		isValid[0] = true;

		for (int i = 1; i <= n; i++) {
			for (int j = i - 1; j >= 0 && i - j <= maxl; j--) {
				String str = A.substring(j, i);

				if (isValid[j] && set.contains(str)) {
					isValid[i] = true;
					break;
				}
			}
		}

		return isValid[n] == true ? 1 : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String A[] = new String[n];
		for (int i = 0; i < n; i++)
			A[i] = s.next();
		System.out.println(new WordBreak().wordBreak(s.next(), A));
		s.close();
	}

}
