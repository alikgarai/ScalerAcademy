package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {

	public ArrayList<Integer> preorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		TreeNode tmp;
		Stack<TreeNode> S = new Stack<>();
		S.push(A);

		while (!S.isEmpty()) {
			tmp = S.pop();
			ans.add(tmp.val);
			if (tmp.right != null)
				S.push(tmp.right);
			if (tmp.left != null)
				S.push(tmp.left);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PreorderTraversal().preorderTraversal(new GetInput().getInput()));
	}

}
