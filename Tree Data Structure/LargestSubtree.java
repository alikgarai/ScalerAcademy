package ib.scaler.day59_Apr6;

import java.util.Scanner;

public class LargestSubtree {

	class Triplet {
		int min;
		int max;
		int size;

		Triplet(int x, int y, int z) {
			min = x;
			max = y;
			size = z;
		}
	}

	int maxSize = 1;

	Triplet Max_Min(TreeNode root) {

		if (root == null)
			return new Triplet(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

		Triplet L = Max_Min(root.left);
		Triplet R = Max_Min(root.right);

		int size;
		if (root.val <= L.max || root.val >= R.min || L.size == -1 || R.size == -1) {
			size = -1;
		} else {
			size = L.size + R.size + 1;
			maxSize = Math.max(maxSize, size);
		}

		return new Triplet(Math.min(root.val, L.min), Math.max(root.val, R.max), size);
	}

	public int solve(TreeNode A) {
		Max_Min(A);

		return maxSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(new LargestSubtree().solve(new GetInput().getInput(s)));
		s.close();
	}

}
