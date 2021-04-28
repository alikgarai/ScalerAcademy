package ib.scaler.day59_Apr6;

import java.util.Scanner;

public class BalancedBST {

	TreeNode createTree(int[] A, int s, int e) {

		if (s > e)
			return null;

		if (s == e)
			return new TreeNode(A[s]);

		int m = (s + e) / 2;
		TreeNode X = new TreeNode(A[m]);
		X.left = createTree(A, s, m - 1);
		X.right = createTree(A, m + 1, e);

		return X;
	}

	public TreeNode sortedArrayToBST(final int[] A) {
		return createTree(A, 0, A.length - 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		System.out.println(new BalancedBST().sortedArrayToBST(A));
		s.close();
	}

}
