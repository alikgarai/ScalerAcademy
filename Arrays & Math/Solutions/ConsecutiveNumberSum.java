package ib.scaler.day114_Jun10;

import java.util.Scanner;

public class ConsecutiveNumberSum {

	public int solve(int A) {
		int cnt = 0;
		double sum;

		for (int i = 0; i * (i + 1) / 2 < A; i++) {
			sum = ((double) A - ((double) i * (i + 1) / 2)) / (i + 1);
			if (sum - (int) sum == 0)
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new ConsecutiveNumberSum().solve(s.nextInt()));
		s.close();
	}

}
