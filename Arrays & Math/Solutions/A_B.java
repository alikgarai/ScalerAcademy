package ib.scaler.day35_Mar8;

import java.util.HashMap;
import java.util.Scanner;

public class A_B {

	public int solve(int[] A, int B, int C) {

		int freq, max = 1;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int temp;

		for (int i = 0; i < A.length; i++) {
			temp = (int) Math.floorMod((long) A[i] * (Math.floorMod((long) A[i] * A[i], C) - B), C);
			if (hm.containsKey(temp)) {
				freq = hm.get(temp);
				freq++;
				max = Math.max(max, freq);
				hm.replace(temp, freq);
			} else
				hm.put(temp, 1);
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
		int B = s.nextInt();
		int C = s.nextInt();
		A_B ab = new A_B();
		System.out.print(ab.solve(A, B, C));
		s.close();
	}

}

// A: 26, 31, 15, 38, 27, 7, 45, 10, 44, 52, 28, 33, 25, 41, 39, 29, 30, 42
// B: 9
// C: 53
// OP: 2

//A: 16, 22, 27, 14, 33, 15, 25, 31, 23
//B: 10
//C: 139
//OP: 1
