package ib.scaler.day48_Mar25;

import java.util.Scanner;

public class GasStation {

	public int canCompleteCircuit(final int[] A, final int[] B) {

		int j, cnt, cap = 0, n = A.length;

		for (int i = 0; i < n; i++)
			cap += A[i] - B[i];

		if (cap < 0)
			return -1;

		for (int i = 0; i < n; i++) {
			if (A[i] >= B[i]) {
				cap = 0;
				j = i;
				cnt = 0;
				while (cnt < n) {
					cap += A[j] - B[j];
					if (cap < 0)
						break;
					j = (j + 1) % n;
					cnt++;
				}
				if (cnt == n)
					return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		System.out.println(new GasStation().canCompleteCircuit(A, B));
		s.close();
	}

}
