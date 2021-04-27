package ib.scaler.day60_Apr7;

import java.util.Scanner;

public class XORQueries {

	public int solve(int A, int B, int C) {
		int max = Integer.MIN_VALUE;

		for (int i = B; i <= C; i++) {
			max = Math.max(max, A ^ i);
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new XORQueries().solve(s.nextInt(), s.nextInt(), s.nextInt()));
		s.close();
	}

}
