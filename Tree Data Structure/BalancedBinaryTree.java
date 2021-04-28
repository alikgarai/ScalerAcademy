package ib.scaler.day56_Apr3;

import java.util.Scanner;

public class BalancedBinaryTree {

	boolean flg = true;

	public int height(TreeNode A) {
		int lh = 0, rh = 0;

		if (A == null)
			return -1;
		else {
			lh = height(A.left);
			rh = height(A.right);

			if (Math.abs(lh - rh) > 1)
				flg = false;
		}

		return Math.max(lh, rh) + 1;
	}

	public int isBalanced(TreeNode A) {
		height(A);

		if (flg == true)
			return 1;
		else
			return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new BalancedBinaryTree().isBalanced(new GetInput().getInput(s)));
		s.close();
	}

}
