package ib.scaler.day15_Feb12;

import java.util.Scanner;

public class SingleNumber2 {

	public int singleNumber2(final int[] A) {
		int cnt, ans = 0;

		for (int i = 0; i <= 31; i++) {
			cnt = 0;
			for (int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1)
					cnt++;
			}
			if (cnt % 3 == 1) {
				ans += 1 << i;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		SingleNumber2 sn = new SingleNumber2();
		System.out.println(sn.singleNumber2(A));
		s.close();
	}

}
