package ib.scaler.day72_Apr20;

import java.util.Scanner;

public class StackingCubes {

	public int solve(int A) {
		int i, count = 1;
		int n = (int) Math.sqrt(A);

		for (i = 2; i <= n; i++) {
			if (i * i == A)
				count++;
			else if (A % i == 0)
				count += 2;
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.print(new StackingCubes().solve(s.nextInt()));
		s.close();
	}

}
