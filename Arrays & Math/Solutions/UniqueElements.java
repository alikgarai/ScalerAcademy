package ib.scaler.day31_Mar4;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueElements {

	public int solve(int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		int cnt = 0;

		for (int i = 0; i < A.length; i++) {
			int val = A[i];

			while (hs.contains(val)) {
				val++;
				cnt++;
			}

			hs.add(val);
		}
		return cnt;
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
		System.out.print(new UniqueElements().solve(A));
		s.close();
	}

}
