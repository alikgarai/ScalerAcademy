package ib.scaler.day56_Apr3;

import java.util.ArrayList;
import java.util.Scanner;

public class IdenticalTrees {

	void fillTreeData(ArrayList<Integer> a, TreeNode A) {
		ArrayList<TreeNode> q = new ArrayList<>();
		TreeNode end, tmp, last;

		if (A == null)
			return;
		q.add(A);
		end = A;
		last = A;
		a.add(A.val);

		while (!q.isEmpty()) {
			tmp = q.remove(0);
			if (tmp.left != null) {
				q.add(tmp.left);
				last = tmp.left;
				a.add(tmp.left.val);
			} else
				a.add(-1);

			if (tmp.right != null) {
				q.add(tmp.right);
				last = tmp.right;
				a.add(tmp.right.val);
			} else
				a.add(-1);

			if (end == tmp)
				end = last;
		}
	}

	public int isSameTree(TreeNode A, TreeNode B) {

		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = new ArrayList<>();

		fillTreeData(a1, A);
		fillTreeData(a2, B);

		int l1 = a1.size();
		int l2 = a2.size();
		if (l1 != l2)
			return 0;
		for (int i = 0; i < l1; i++) {
			if (!a1.get(i).equals(a2.get(i)))
				return 0;
		}

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		GetInput gi = new GetInput();
		TreeNode A = gi.getInput(s);
		TreeNode B = gi.getInput(s);
		System.out.println(new IdenticalTrees().isSameTree(A, B));
		s.close();
	}

}
