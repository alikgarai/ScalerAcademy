package ib.scaler.day56_Apr3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TopView {

	class Node {
		TreeNode A;
		int lvl;

		Node(TreeNode tn, int l) {
			A = tn;
			lvl = l;
		}
	}

	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		Queue<Node> q = new LinkedList<>();
		TreeNode end, last;
		Node tmp;

		q.add(new Node(A, 0));
		end = A;
		last = A;

		while (!q.isEmpty()) {
			tmp = q.remove();
			if (tmp.A.left != null) {
				q.add(new Node(tmp.A.left, tmp.lvl - 1));
				last = tmp.A.left;
			}
			if (tmp.A.right != null) {
				q.add(new Node(tmp.A.right, tmp.lvl + 1));
				last = tmp.A.right;
			}
			if (!set.contains(tmp.lvl)) {
				ans.add(tmp.A.val);
				set.add(tmp.lvl);
			}
			if (end == tmp.A)
				end = last;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new TopView().solve(new GetInput().getInput(s)));
		s.close();
	}

}
