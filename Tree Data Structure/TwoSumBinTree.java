package ib.scaler.day59_Apr6;

import java.util.Scanner;
import java.util.Stack;

public class TwoSumBinTree {

	public int t2Sum(TreeNode A, int B) {
		int val;

		TreeNode tmp, curr;
		Stack<TreeNode> S = new Stack<>();
		curr = A;

		while (curr != null || !S.isEmpty()) {
			if (curr != null) {

				val = B - curr.val;
				tmp = A;
				while (tmp != null) {
					if (tmp.val == val && tmp != curr) {
						return 1;
					} else if (tmp.val > val)
						tmp = tmp.left;
					else
						tmp = tmp.right;
				}

				S.push(curr);
				curr = curr.left;
			} else
				curr = S.pop().right;
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new TwoSumBinTree().t2Sum(new GetInput().getInput(s), s.nextInt()));
		s.close();
	}

}
