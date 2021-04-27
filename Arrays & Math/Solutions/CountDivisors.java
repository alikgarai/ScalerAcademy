package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class CountDivisors {

	public int[] solve(int[] A) {

		int l = A.length;
		int ans[] = new int[l];
		int B[] = new int[1000001];

		for (int i = 0; i <= 1000000; i++)
			B[i] = 1;

		for (int i = 2; i <= 1000000; i++) {
			for (int j = i; j <= 1000000; j += i) {
				B[j]++;
			}
		}

		for (int i = 0; i < l; i++) {
			ans[i] = B[A[i]];
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

		CountDivisors ln = new CountDivisors();
		A = ln.solve(A);
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}

		s.close();
	}

}
