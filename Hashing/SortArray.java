package ib.scaler.day36_Mar11;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class SortArray {

	public int[] solve(int[] A, int[] B) {
		TreeMap<Integer, Integer> tm = new TreeMap<>();
		int freq, l = A.length;
		int ans[] = new int[l];
		int k = 0, val;

		for (int i = 0; i < l; i++) {
			if (tm.containsKey(A[i])) {
				freq = tm.get(A[i]) + 1;
				tm.replace(A[i], freq);
			} else
				tm.put(A[i], 1);
		}

		for (int i = 0; i < B.length; i++) {
			if (tm.containsKey(B[i])) {
				freq = tm.get(B[i]);
				while (freq > 0) {
					ans[k++] = B[i];
					freq--;
				}
				tm.replace(B[i], freq);
			}
		}
		Set<Integer> set = tm.keySet();
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			val = iter.next();
			freq = tm.get(val);
			while (freq > 0) {
				ans[k++] = val;
				freq--;
			}
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
		n = s.nextInt();
		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		SortArray sa = new SortArray();
		System.out.println(Arrays.toString(sa.solve(A, B)));
		s.close();
	}

}
