package ib.scaler.day56_Apr3;

import java.util.ArrayList;
import java.util.Scanner;

public class DifferenceBwlevels {

	public int solve(TreeNode A) {

		ArrayList<TreeNode> q = new ArrayList<>();
		TreeNode end, tmp, last;
		int sum = 0, oddsum = A.val, evensum = 0, lvl = 2;

		q.add(A);
		end = A;
		last = A;

		while (!q.isEmpty()) {
			tmp = q.remove(0);
			if (tmp.left != null) {
				q.add(tmp.left);
				last = tmp.left;
				sum += tmp.left.val;
			}
			if (tmp.right != null) {
				q.add(tmp.right);
				last = tmp.right;
				sum += tmp.right.val;
			}
			if (end == tmp) {
				end = last;
				if (lvl % 2 == 1)
					oddsum += sum;
				else
					evensum += sum;
				sum = 0;
				lvl++;
			}
		}

		return oddsum - evensum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new DifferenceBwlevels().solve(new GetInput().getInput(s)));
		s.close();
	}

}
