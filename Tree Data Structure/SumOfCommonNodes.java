package ib.scaler.day59_Apr6;

import java.util.ArrayList;
import java.util.Scanner;

public class SumOfCommonNodes {

	public void inorder(ArrayList<Integer> ans, TreeNode A) {
		if (A != null) {
			inorder(ans, A.left);
			ans.add(A.val);
			inorder(ans, A.right);
		}
	}

	public int solve(TreeNode A, TreeNode B) {
		ArrayList<Integer> X = new ArrayList<>();
		ArrayList<Integer> Y = new ArrayList<>();
		long sum = 0;
		int i = 0, j = 0;

		inorder(X, A);
		inorder(Y, B);
		int l1 = X.size();
		int l2 = Y.size();

		while (i < l1 && j < l2) {
			if (X.get(i) < Y.get(j))
				i++;
			else if (X.get(i) > Y.get(j))
				j++;
			else {
				sum += X.get(i);
				i++;
				j++;
			}
		}

		return (int) (sum % 1000000007);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		GetInput gi = new GetInput();
		TreeNode A = gi.getInput(s);
		TreeNode B = gi.getInput(s);
		System.out.println(new SumOfCommonNodes().solve(A, B));
		s.close();
	}

}
