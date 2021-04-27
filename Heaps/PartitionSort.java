package ib.scaler.day114_Jun10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PartitionSort {

	public int solve(int[] A) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int n = A.length, cnt = 0;
		boolean flg;

		int B[] = new int[n];
		for (int i = 0; i < n; i++)
			B[i] = A[i];

		Arrays.sort(B);

		for (int i = 0; i < n; i++) {
			if (map.containsKey(B[i])) {
				map.replace(B[i], map.get(B[i]) + 1);
				if (A[i] != B[i] && map.get(B[i]) == 0)
					map.remove(B[i]);
			} else
				map.put(B[i], 1);

			if (map.containsKey(A[i])) {
				map.replace(A[i], map.get(A[i]) - 1);
				if (map.get(A[i]) == 0)
					map.remove(A[i]);
			} else
				map.put(A[i], -1);

			flg = true;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() != 0) {
					flg = false;
					break;
				}
			}
			if (flg == true)
				cnt++;
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new PartitionSort().solve(A));
		s.close();
	}

}
