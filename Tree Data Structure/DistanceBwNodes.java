package ib.scaler.day59_Apr6;

import java.util.Scanner;

public class DistanceBwNodes {

	public int solve(TreeNode A, int B, int C) {
		int lcnt = 0, rcnt = 0;
		TreeNode tmp = A, troot;

		while (tmp != null) {
			if (B < tmp.val && C < tmp.val)
				tmp = tmp.left;
			else if (B > tmp.val && C > tmp.val)
				tmp = tmp.right;
			else
				break;
		}

		troot = tmp;
		while (tmp != null) {
			if (B < tmp.val)
				tmp = tmp.left;
			else if (B == tmp.val)
				break;
			else
				tmp = tmp.right;

			lcnt++;
		}

		tmp = troot;
		while (tmp != null) {
			if (C < tmp.val)
				tmp = tmp.left;
			else if (C == tmp.val)
				break;
			else
				tmp = tmp.right;

			rcnt++;
		}

		return lcnt + rcnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		TreeNode A = new GetInput().getInput(s);
		int B = s.nextInt();
		int C = s.nextInt();
		System.out.println(new DistanceBwNodes().solve(A, B, C));
		s.close();
	}

}
