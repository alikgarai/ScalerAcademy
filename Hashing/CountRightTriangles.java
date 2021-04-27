package ib.scaler.day38_Mar13;

import java.util.HashMap;
import java.util.Scanner;

public class CountRightTriangles {

	int mod = 1000000007;

	public int solve(int[] A, int[] B) {
		HashMap<Integer, Integer> x = new HashMap<>();
		HashMap<Integer, Integer> y = new HashMap<>();

		long contribution = 0;

		for (int i = 0; i < A.length; i++) {
			if (x.containsKey(A[i]))
				x.replace(A[i], x.get(A[i]) + 1);
			else
				x.put(A[i], 1);

			if (y.containsKey(B[i]))
				y.replace(B[i], y.get(B[i]) + 1);
			else
				y.put(B[i], 1);
		}

		for (int i = 0; i < A.length; i++)
			contribution += ((long) (x.get(A[i]) - 1) * (y.get(B[i]) - 1)) % mod;

		return (int) contribution;
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
		System.out.println(new CountRightTriangles().solve(A, B));
		s.close();
	}

}
