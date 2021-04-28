package ib.scaler.day59_Apr6;

import java.util.ArrayList;
import java.util.Scanner;

public class BSTnodesinRange {

	public void inorder(ArrayList<Integer> ans, TreeNode A) {
		if (A != null) {
			inorder(ans, A.left);
			ans.add(A.val);
			inorder(ans, A.right);
		}
	}

	public int search(ArrayList<Integer> A, int val) {
		int st = 0, end, mid;

		end = A.size() - 1;
		mid = (st + end) / 2;

		while (st <= end) {
			if (A.get(mid).equals(val)) {
				while (--mid >= 0 && A.get(mid).equals(val))
					;
				return mid + 1;
			} else if (A.get(mid).compareTo(val) > 0)
				end = mid - 1;
			else
				st = mid + 1;

			mid = (st + end) / 2;
		}

		return st;
	}

	public int solve(TreeNode A, int B, int C) {

		ArrayList<Integer> arr = new ArrayList<>();
		inorder(arr, A);
		int len = arr.size();

		if (len < 2)
			return 0;

		int l = search(arr, B);
		l = (l < 0) ? 0 : (l >= len) ? len - 1 : l;
		int r = search(arr, C);
		r = (r < 0) ? 0 : (r >= len) ? len - 1 : r;

		if (arr.get(r) >= B && arr.get(r) <= C)
			return r - l + 1;
		else
			return r - l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		TreeNode A = new GetInput().getInput(s);
		int B = s.nextInt();
		int C = s.nextInt();

		System.out.println(new BSTnodesinRange().solve(A, B, C));

		s.close();
	}

}
