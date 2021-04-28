package ib.scaler.day56_Apr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftView {

	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode end, tmp, last;

		q.add(A);
		end = A;
		last = A;
		ans.add(A.val);

		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp.left != null) {
				q.add(tmp.left);
				last = tmp.left;
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				last = tmp.right;
			}
			if (end == tmp) {
				end = last;
				if (!q.isEmpty())
					ans.add(q.peek().val);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LeftView().solve(new GetInput().getInput(s)));
		s.close();
	}

}
