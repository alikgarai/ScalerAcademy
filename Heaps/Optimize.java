package ib.scaler.day119_Jun15;

import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Optimize {

	public int solve(int[] A) {
		int n = A.length;

		TreeSet<Integer> s1 = new TreeSet<>();
		TreeSet<Integer> s2 = new TreeSet<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		int max = -1;
		s1.add(A[0]);

		for (int i = 1; i < n; i++) {
			s2.add(A[i]);
			if (map.containsKey(A[i]))
				map.replace(A[i], map.get(A[i]) + 1);
			else
				map.put(A[i], 1);
		}

		for (int i = 1; i < n - 1; i++) {
			if (map.get(A[i]) > 1)
				map.replace(A[i], map.get(A[i]) - 1);
			else
				s2.remove(A[i]);
			try {
				s1.add(A[i]);
				int x = s1.lower(A[i]);
				int z = s2.last();

				if (x < A[i] && A[i] < z) {
					int sum = x + A[i] * z;
					max = Math.max(max, sum);
				}
			} catch (Exception e) {
				continue;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new Optimize().solve(A));
		s.close();
	}

}
