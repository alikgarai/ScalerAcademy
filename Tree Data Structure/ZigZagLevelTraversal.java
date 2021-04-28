package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelTraversal {

	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int lvl = 0;
		Stack<TreeNode> l2r = new Stack<>();
		Stack<TreeNode> r2l = new Stack<>();
		TreeNode tmp;
		ArrayList<Integer> a = new ArrayList<>();
		l2r.push(A);

		while (!l2r.isEmpty() || !r2l.isEmpty()) {
			if (lvl % 2 == 0) {
				while (!l2r.isEmpty()) {
					tmp = l2r.pop();
					a.add(tmp.val);
					if (tmp.left != null)
						r2l.push(tmp.left);
					if (tmp.right != null)
						r2l.push(tmp.right);
				}
			} else {
				while (!r2l.isEmpty()) {
					tmp = r2l.pop();
					a.add(tmp.val);
					if (tmp.right != null)
						l2r.push(tmp.right);
					if (tmp.left != null)
						l2r.push(tmp.left);
				}
			}
			ans.add(a);
			a = new ArrayList<>();
			lvl++;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ZigZagLevelTraversal().zigzagLevelOrder(new GetInput().getInput()));
	}
}
