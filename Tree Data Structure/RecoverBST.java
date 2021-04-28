package ib.scaler.day59_Apr6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RecoverBST {

	public int[] recoverTree(TreeNode A) {
		int ans[] = new int[2];
		ArrayList<Integer> X = new ArrayList<>();
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
				X.add(tmp.val);
			}
		}

		int i = 1, l = X.size();
		while (i < l) {
			if (X.get(i) < X.get(i - 1)) {
				ans[0] = X.get(i);
				ans[1] = X.get(i - 1);
				i++;
				break;
			}
			i++;
		}
		while (i < l) {
			if (X.get(i) < X.get(i - 1)) {
				ans[0] = X.get(i);
				break;
			}
			i++;
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A[] = new RecoverBST().recoverTree(new GetInput().getInput(s));
		System.out.println(A[0] + " " + A[1]);
		s.close();
	}

}
