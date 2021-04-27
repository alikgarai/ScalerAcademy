package ib.scaler.day35_Mar8;

import java.util.Arrays;
import java.util.Scanner;

public class HideBoxes {

	public int solve(int[] A) {
		int cnt = 0, x, y;
		Arrays.sort(A);
		x = A.length / 2 - 1;
		y = A.length - 1;

		while (x >= 0) {
			if (A[y] >= 2 * A[x]) {
				cnt++;
				y--;
			}
			x--;
		}
		return A.length - cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();

		HideBoxes hb = new HideBoxes();
		System.out.println(hb.solve(A));
		s.close();
	}

}
