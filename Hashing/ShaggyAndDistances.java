package ib.scaler.day36_Mar11;

import java.util.HashMap;
import java.util.Scanner;

public class ShaggyAndDistances {

	public int solve(int[] A) {
		int min = Integer.MAX_VALUE;

		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i])) {
				min = Math.min(min, i - hm.get(A[i]));
				hm.replace(A[i], i);
			} else {
				hm.put(A[i], i);
			}
		}

		return (min == Integer.MAX_VALUE ? -1 : min);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		ShaggyAndDistances sd = new ShaggyAndDistances();
		System.out.print(sd.solve(A));
		s.close();
	}

}
