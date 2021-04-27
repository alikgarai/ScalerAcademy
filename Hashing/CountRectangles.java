package ib.scaler.day38_Mar13;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CountRectangles {

	public int solve(int[] A, int[] B) {
		int count = 0;
		Set<int[]> hs = new TreeSet<>((a1, a2) -> {
			if (Arrays.equals(a1, a2))
				return 0;
			if (a1[0] != a2[0])
				return Integer.valueOf(a1[0]).compareTo(Integer.valueOf(a2[0]));
			return Integer.valueOf(a1[1]).compareTo(Integer.valueOf(a2[1]));
		});

		for (int i = 0; i < A.length; i++)
			hs.add(new int[] { A[i], B[i] });

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				if (A[i] != A[j] && B[i] != B[j] && hs.contains(new int[] { A[i], B[j] })
						&& hs.contains(new int[] { A[j], B[i] }))
					count++;
			}
		}

		return count / 2;
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
		System.out.println(new CountRectangles().solve(A, B));
		s.close();
	}

}
