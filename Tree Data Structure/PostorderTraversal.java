package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {

	public ArrayList<Integer> postorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<TreeNode> S = new Stack<>();
		TreeNode tmp;
		S.push(A);

		while (!S.isEmpty()) {
			tmp = S.pop();
			ans.add(0, tmp.val);
			if (tmp.left != null)
				S.add(tmp.left);
			if (tmp.right != null)
				S.add(tmp.right);
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PostorderTraversal().postorderTraversal(new GetInput().getInput()));
	}
}
