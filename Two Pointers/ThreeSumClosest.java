package ib.scaler.day33_Mar6;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {

	public int threeSumClosest(int[] A, int B) {

		int i, j, k, d, sum, l, min, ans = 0;
		l = A.length;
		min = Integer.MAX_VALUE;
		Arrays.sort(A);

		for (i = 0; i < l - 2; i++) {
			j = i + 1;
			k = l - 1;
			while (j < k) {
				sum = A[i] + A[j] + A[k];
				d = Math.abs(sum - B);
				if (d == 0) {
					return sum;
				}
				if (d < min) {
					min = d;
					ans = sum;
				}
				if (sum <= B)
					j++;
				else
					k--;
			}
		}

		return ans;
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
		int b = s.nextInt();
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.print(tsc.threeSumClosest(A, b));
		s.close();
	}

}
