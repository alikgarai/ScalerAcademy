package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class VerticalOrderTraversal {

	class Node {
		TreeNode A;
		int lvl;

		Node(TreeNode tn, int l) {
			A = tn;
			lvl = l;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap<>();
		Queue<Node> q = new LinkedList<>();
		TreeNode end, last, top;
		Node tmp;

		if (A == null)
			return ans;

		q.add(new Node(A, 0));
		end = A;
		last = A;

		while (!q.isEmpty()) {
			top = q.peek().A;
			tmp = q.remove();
			if (tmp.A.left != null) {
				q.add(new Node(tmp.A.left, tmp.lvl - 1));
				last = tmp.A.left;
			}
			if (tmp.A.right != null) {
				q.add(new Node(tmp.A.right, tmp.lvl + 1));
				last = tmp.A.right;
			}
			if (!tm.containsKey(tmp.lvl)) {
				tm.put(tmp.lvl, new ArrayList<>());
			}
			tm.get(tmp.lvl).add(tmp.A.val);

			if (end == top)
				end = last;
		}

		Set<Integer> keys = tm.keySet();
		keys.forEach(key -> {
			ans.add(tm.get(key));
		});

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(new VerticalOrderTraversal().verticalOrderTraversal(new GetInput().getInput()));
	}

}
