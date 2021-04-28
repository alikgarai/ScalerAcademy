package ib.scaler.day42_Mar18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class OrderedSubstring {

	public String[] solve(String[] A) {

		Arrays.sort(A, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() == s2.length() ? 0 : s1.length() > s2.length() ? 1 : -1;
			}
		});

		for (int i = 1; i < A.length; i++) {
			if (!A[i].contains(A[i - 1]))
				return new String[] { "NO" };
		}

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		String A[] = new String[n];
		for (int i = 0; i < n; i++)
			A[i] = s.next();
		OrderedSubstring os = new OrderedSubstring();
		A = os.solve(A);
		System.out.println(Arrays.toString(A));
		s.close();
	}

}
