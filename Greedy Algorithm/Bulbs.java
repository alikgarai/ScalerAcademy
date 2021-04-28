package ib.scaler.day72_Apr20;

import java.util.Scanner;

public class Bulbs {

	public int bulbs(int[] A) {
		int cnt = 0;

		for (int i = 0; i < A.length; i++) {
			if ((A[i] == 0 && cnt % 2 == 0) || (A[i] == 1 && cnt % 2 == 1)) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		System.out.println(new Bulbs().bulbs(A));
		s.close();
	}

}
