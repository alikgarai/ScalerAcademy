package ib.scaler.day54_Apr1;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {

//	public void inorder(ArrayList<Integer> ans, TreeNode A) {
//		if (A != null) {
//			inorder(ans, A.left);
//			ans.add(A.val);
//			inorder(ans, A.right);
//		}
//	}

	public ArrayList<Integer> inorderTraversal(TreeNode A) {
		ArrayList<Integer> ans = new ArrayList<>();
//		inorder(ans, A);
		TreeNode tmp, curr;
		Stack<TreeNode> S = new Stack<>();
		curr = A;

		while (curr != null || !S.isEmpty()) {
			if (curr != null) {
				S.push(curr);
				curr = curr.left;
			} else {
				tmp = S.pop();
				curr = tmp.right;
				ans.add(tmp.val);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new InorderTraversal().inorderTraversal(new GetInput().getInput()));
	}

}
