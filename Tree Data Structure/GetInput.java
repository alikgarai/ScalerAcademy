package ib.scaler.day61_Apr8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GetInput {

	TreeNode getInput(Scanner s) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode root = null, tmp, left, right;
		int n, val;

		n = s.nextInt();
		while (n > 0) {
			if (q.isEmpty()) {
				tmp = new TreeNode(s.nextInt());
				n--;
				q.add(tmp);
				root = tmp;
			} else {
				tmp = q.remove();
				val = s.nextInt();
				n--;
				left = (val != -1) ? new TreeNode(val) : null;
				if (left != null) {
					q.add(left);
					tmp.left = left;
				}
				val = s.nextInt();
				n--;
				right = (val != -1) ? new TreeNode(val) : null;
				if (right != null) {
					q.add(right);
					tmp.right = right;
				}
			}
		}
		return root;
	}

}
