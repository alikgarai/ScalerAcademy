package ib.scaler.day61_Apr8;

import java.util.Scanner;

public class KDistance {

	int count = 0;

	void calc2(int val, TreeNode A, int B) {
		if (A.left != null) {
			if (Math.abs(val - A.left.val) <= B)
				count++;
			calc2(val, A.left, B);
		}

		if (A.right != null) {
			if (Math.abs(val - A.right.val) <= B)
				count++;
			calc2(val, A.right, B);
		}
	}

	void calc1(TreeNode A, int B) {
		calc2(A.val, A, B);

		if (A.left != null)
			calc1(A.left, B);

		if (A.right != null)
			calc1(A.right, B);

	}

	public int solve(TreeNode A, int B) {
		calc1(A, B);

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		GetInput gi = new GetInput();
		TreeNode A = gi.getInput(s);
		int B = s.nextInt();
		System.out.println(new KDistance().solve(A, B));
		s.close();
	}

}
