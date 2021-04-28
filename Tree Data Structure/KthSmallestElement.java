package ib.scaler.day59_Apr6;

import java.util.Scanner;
import java.util.Stack;

public class KthSmallestElement {

	public int kthsmallest(TreeNode A, int B) {

		TreeNode tmp, curr;
		Stack<TreeNode> S = new Stack<>();
		curr = A;
		int cnt = 0;

		while (curr != null || !S.isEmpty()) {
			if (curr != null) {
				S.push(curr);
				curr = curr.left;
			} else {
				tmp = S.pop();
				curr = tmp.right;
				cnt++;
				if (cnt == B)
					return tmp.val;
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		System.out.println(new KthSmallestElement().kthsmallest(new GetInput().getInput(s), s.nextInt()));
		s.close();
	}

}
