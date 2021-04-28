package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> al;
		TreeNode end, tmp, last, top;

		q.add(A);
		end = A;
		last = A;

		al = new ArrayList<Integer>();
		while (!q.isEmpty()) {
			top = q.peek();
			tmp = q.remove();
			if (tmp.left != null) {
				q.add(tmp.left);
				last = tmp.left;
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				last = tmp.right;
			}
			al.add(tmp.val);
			if (end == top) {
				ans.add(al);
				end = last;
				al = new ArrayList<Integer>();
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LevelOrderTraversal().levelOrder(new GetInput().getInput()));
	}
}
