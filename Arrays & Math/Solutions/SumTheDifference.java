package ib.scaler.day31_Mar4;

import java.util.Arrays;
import java.util.Scanner;

public class SumTheDifference {

	int mod = 1000000007;

	public int solve(int[] A) {

		Arrays.sort(A);
		int n = A.length;
		long sum = 0;

		int pow[] = new int[n + 1];
		pow[0] = 1;
		for (int i = 1; i <= n; i++)
			pow[i] = (int) ((long) pow[i - 1] * 2) % mod;

		for (int i = 0; i < n; i++)
			sum = (sum + Math.floorMod((long) A[i] * (pow[i] - pow[n - i - 1]), mod)) % mod;

		return (int) sum;
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
		System.out.print(new SumTheDifference().solve(A));
		s.close();
	}

}
