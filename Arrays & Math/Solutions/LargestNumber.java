package ib.scaler.day31_Mar4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {

	public String largestNumber(final int[] A) {

		String[] ans = new String[A.length];

		for (int i = 0; i < A.length; i++) {
			ans[i] = String.valueOf(A[i]);
		}
		Arrays.sort(ans, new Comparator<String>() {
			public int compare(String X, String Y) {
				String XY = X + Y;
				String YX = Y + X;

				return YX.compareTo(XY);
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length; i++)
			sb.append(ans[i]);

		while (sb.charAt(0) == '0' && sb.length() > 0)
			sb.deleteCharAt(0);

		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}
		System.out.print(new LargestNumber().largestNumber(A));
		s.close();
	}
}
