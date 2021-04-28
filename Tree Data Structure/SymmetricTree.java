package ib.scaler.day56_Apr3;

import java.util.ArrayList;
import java.util.Scanner;

public class SymmetricTree {

	public int isSymmetric(TreeNode A) {
		ArrayList<TreeNode> q = new ArrayList<>();
		TreeNode end, tmp, last;

		q.add(A);
		end = A;
		last = A;

		while (!q.isEmpty()) {
			tmp = q.remove(0);
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

				int size = q.size();
				if (size % 2 == 1)
					return 0;
				int hd = 0, tl = size - 1;

				while (hd < tl) {
					if (q.get(hd).val != q.get(tl).val)
						return 0;
					hd++;
					tl--;
				}
			}
		}

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new SymmetricTree().isSymmetric(new GetInput().getInput(s)));
		s.close();
	}

}
