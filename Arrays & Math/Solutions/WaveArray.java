package ib.scaler.day29_Mar2;

import java.util.Arrays;
import java.util.Scanner;

public class WaveArray {

	public int[] wave(int[] A) {

		Arrays.sort(A);

		if (A.length == 1)
			return A;

		int l = (A.length % 2 == 0) ? A.length - 1 : A.length - 2;
		int tmp;

		for (int i = 0; i < l; i += 2) {
			tmp = A[i];
			A[i] = A[i + 1];
			A[i + 1] = tmp;
		}
		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n, A[];

		n = s.nextInt();
		A = new int[n];
		for (int i = 0; i < n; i++) {
			A[i] = s.nextInt();
		}

		WaveArray c = new WaveArray();
		A = c.wave(A);
		for (int i = 0; i < n; i++) {
			System.out.print(A[i] + " ");
		}
		s.close();
	}
}
