package ib.scaler.day33_Mar6;

import java.util.Scanner;

public class ContainerWithMostWater {

	public int maxArea(int[] A) {
		int maxArea = 0, i = 0, j = A.length - 1, min, area;

		while (i < j) {
			min = Math.min(A[i], A[j]);
			area = (j - i) * min;
			maxArea = Math.max(maxArea, area);
			if (A[i] == min)
				i++;
			else
				j--;
		}

		return maxArea;
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
		ContainerWithMostWater co = new ContainerWithMostWater();
		System.out.print(co.maxArea(A));
		s.close();
	}

}
