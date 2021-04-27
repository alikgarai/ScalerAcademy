package ib.scaler.day66_Apr13;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GoodRanges {

	public int[] solve(int A, int[] B) {
		int lastMin = B[0], lastMax = B[0];
		long sum = A + 1;
		int mod = 1000000007;
		HashSet<Integer> hs = new HashSet<>();
		hs.add(B[0]);

		int ans[] = new int[B.length];
		ans[0] = A + 1;

		for (int i = 1; i < B.length; i++) {
			if (!hs.contains(B[i])) {
				hs.add(B[i]);
				if (B[i] > lastMax) {
					sum = (sum + lastMax + B[i]) % mod;
					lastMax = B[i];
				} else if (B[i] < lastMin) {
					sum = (sum + lastMin + B[i]) % mod;
					lastMin = B[i];
				} else
					sum = (sum + 2 * B[i]) % mod;
			}
			ans[i] = (int) sum;
		}

		return ans;
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
		System.out.print(Arrays.toString(new GoodRanges().solve(s.nextInt(), A)));
		s.close();
	}

}
