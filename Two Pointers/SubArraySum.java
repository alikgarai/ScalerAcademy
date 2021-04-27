package ib.scaler.day33_Mar6;

import java.util.Arrays;
import java.util.Scanner;

public class SubArraySum {

	public int[] solve(int[] A, int B) {
		long sum = A[0];
		int i = 0, j = 1;
		int ans[] = { -1 };

		while (i < A.length && j < A.length) {
			if (i == j) {
				sum += A[i];
				j = (i == A.length - 1) ? i : i + 1;
			}
			if (sum == B) {
				ans = Arrays.copyOfRange(A, i, j);
				break;
			} else if (sum < B) {
				sum += A[j++];
			} else {
				sum -= A[i++];
			}
		}

		while (ans[0] == -1 && i < j) {
			if (sum == B) {
				ans = Arrays.copyOfRange(A, i, j);
				break;
			} else {
				sum -= A[i++];
			}
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
		int b = s.nextInt();
		SubArraySum sas = new SubArraySum();
		A = sas.solve(A, b);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}

}
