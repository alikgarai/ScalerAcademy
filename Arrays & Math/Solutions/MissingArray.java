package ib.scaler.day145_Jul17;

import java.util.Arrays;
import java.util.Scanner;

public class MissingArray {

	public int[] solve(char[] A) {
		int[] ans = new int[A.length];

		int cnt = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == '+')
				cnt++;
		}
		int x = A.length - cnt;
		int y = x + 1;

		for (int i = 0; i < A.length; i++) {
			char c = A[i];
			if (c == '.' || c == '-')
				ans[i] = x--;
			else
				ans[i] = y++;
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		char[] A = new char[n];
		for (int i = 0; i < n; i++)
			A[i] = s.next().charAt(0);
		System.out.println(Arrays.toString(new MissingArray().solve(A)));
		s.close();
	}

}
