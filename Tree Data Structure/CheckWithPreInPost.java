package ib.scaler.day54_Apr1;

import java.util.Scanner;

public class CheckWithPreInPost {

	public int check(int[] A, int[] B, int[] C, int st, int end, int root, int pre_x, int pos_x) {
		int i, l, r, left, right, leftst = 1, rightst = 1;

		if (root != C[pos_x])
			return 0;

		for (i = st; i <= end; i++) {
			if (root == B[i]) {
				break;
			}
		}
		l = i - st;
		r = end - i;

		if (l > 0) {
			left = A[pre_x + 1];
			leftst = check(A, B, C, st, i - 1, left, pre_x + 1, pos_x - r - 1);
		}
		if (r > 0) {
			right = A[pre_x + l + 1];
			rightst = check(A, B, C, i + 1, end, right, pre_x + l + 1, pos_x - 1);
		}

		if (leftst == 1 || rightst == 1)
			return 1;
		else
			return 0;
	}

	public int solve(int[] A, int[] B, int[] C) {
		return check(A, B, C, 0, A.length - 1, A[0], 0, A.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];
		int C[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();
		for (int i = 0; i < n; i++)
			C[i] = s.nextInt();

		System.out.println(new CheckWithPreInPost().solve(A, B, C));
		s.close();
	}

}
