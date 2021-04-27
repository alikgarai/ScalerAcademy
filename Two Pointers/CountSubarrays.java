package ib.scaler.day33_Mar6;

import java.util.HashMap;
import java.util.Scanner;

public class CountSubarrays {

	public int solve(int[] A) {

		int s = 0, e = 1;
		long count = 1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		hm.put(A[0], 0);

		while (e < A.length) {
			if (hm.containsKey(A[e])) {
				s = hm.get(A[e]) >= s ? hm.get(A[e]) + 1 : s;
				hm.replace(A[e], e);
			} else
				hm.put(A[e], e);

			count += e - s + 1;
			e++;
		}
		return (int) (count % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		CountSubarrays cs = new CountSubarrays();
		System.out.println(cs.solve(A));
		s.close();
	}

}
