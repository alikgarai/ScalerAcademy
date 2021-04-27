package ib.scaler.day31_Mar4;

import java.util.HashMap;
import java.util.Scanner;

public class GameOfBottles {

	public int solve(int[] A) {

//		Arrays.sort(A);
//		ArrayList<Integer> A1 = new ArrayList<>();
//		ArrayList<Integer> A2 = new ArrayList<>();
//		ArrayList<Integer> tmp;
//		int cnt = 0;
//		A1.add(A[0]);
//
//		for (int i = 1; i < A.length; i++) {
//			if (A[i] == A[i - 1]) {
//				A2.add(A[i]);
//			} else
//				A1.add(A[i]);
//		}
//
//		while (A1.size() > 0) {
//			cnt++;
//			A1.clear();
//			tmp = A2;
//			A2 = A1;
//			A1 = tmp;
//
//			for (int i = 1; i < A1.size(); i++) {
//				if (A1.get(i).equals(A1.get(i - 1)))
//					A2.add(A1.get(i));
//			}
//		}

		HashMap<Integer, Integer> H = new HashMap<>();
		int cnt = 1;

		for (int i = 0; i < A.length; i++) {
			if (H.containsKey(A[i])) {
				H.replace(A[i], H.get(A[i]) + 1);
				cnt = Math.max(cnt, H.get(A[i]));
			} else {
				H.put(A[i], 1);
			}
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

		GameOfBottles gob = new GameOfBottles();
		System.out.print(gob.solve(A));
		s.close();
	}

}
