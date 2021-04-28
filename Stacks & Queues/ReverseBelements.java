package ib.scaler.day48_Mar25;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseBelements {

	public int[] solve(int[] A, int B) {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < B; i++)
			q.add(A[i]);
		for (int i = B - 1; i >= 0; i--)
			A[i] = q.remove();

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		int B = s.nextInt();
		System.out.println(Arrays.toString(new ReverseBelements().solve(A, B)));
		s.close();
	}

}
