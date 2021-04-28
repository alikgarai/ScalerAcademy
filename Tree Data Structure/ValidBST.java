package ib.scaler.day59_Apr6;

import java.util.Scanner;

public class ValidBST {

	class Pair {
		int min;
		int max;

		Pair(int x, int y) {
			min = x;
			max = y;
		}
	}

	int isBST = 1;

	Pair Max_Min(TreeNode root) {
		if (root == null)
			return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

		Pair L = Max_Min(root.left);
		Pair R = Max_Min(root.right);

		if (root.val <= L.max || root.val >= R.min)
			isBST = 0;

		return new Pair(Math.min(root.val, L.min), Math.max(root.val, R.max));
	}

	public int isValidBST(TreeNode A) {
		Max_Min(A);

		return isBST;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new ValidBST().isValidBST(new GetInput().getInput(s)));
		s.close();
	}

}
