package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class PrimeSum {

	public int[] primesum(int A) {

		int ans[] = new int[2];

		int B[] = new int[A];

		for (int i = 0; i < A; i++)
			B[i] = 1;

		for (int i = 2; i < A; i++) {
			if (B[i] != 1)
				continue;
			for (int j = 2 * i; j < A; j += i) {
				B[j] = 0;
			}
		}

		for (int i = 2; i < A; i++) {
			if (B[i] == 1 && B[A - i] == 1) {
				ans[0] = i;
				ans[1] = A - i;
				break;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A[] = new int[2];
		int x = s.nextInt();

		PrimeSum ln = new PrimeSum();
		A = ln.primesum(x);
		for (int i = 0; i < 2; i++) {
			System.out.print(A[i] + " ");
		}

		s.close();
	}

}
