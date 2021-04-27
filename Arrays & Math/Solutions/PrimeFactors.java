/*You are given a Task as described below :
You are given A queries. For each query(1<=i<=A) you are given a prime number B[i], you need to give the count of all numbers in range 1 to 10^6 inclusive which have minimum prime factor B[i] for each query.
*/

package ib.scaler.day11_Feb7;

import java.util.Scanner;

public class PrimeFactors {

	public int[] solve(int A, int[] B) {

		int l = 1000001;
		int M[] = new int[l];
		int count;

		for (int i = 0; i < l; i++)
			M[i] = Integer.MAX_VALUE;

		for (int i = 2; i < l; i++) {
			if (M[i] != Integer.MAX_VALUE)
				continue;
			for (int j = i; j < l; j += i) {
				if (M[j] == Integer.MAX_VALUE)
					M[j] = i;
			}
		}

		for (int i = 0; i < A; i++) {
			count = 0;
			for (int j = B[i]; j < l; j += B[i]) {
				if (M[j] == B[i])
					count++;
			}
			B[i] = count;
		}

		return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		PrimeFactors pf = new PrimeFactors();
		A = pf.solve(n, A);
		for (int i = 0; i < n; i++)
			System.out.print(A[i] + " ");
		s.close();
	}
}
