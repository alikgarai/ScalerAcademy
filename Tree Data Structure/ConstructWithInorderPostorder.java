package ib.scaler.day54_Apr1;

import java.util.Scanner;

public class ConstructWithInorderPostorder {

	public void construct(TreeNode Node, int[] A, int[] B, int st, int end, int x) {
		int root = Node.val;
		int cnt = 0, l, r;

		for (int i = st; i <= end; i++) {
			if (A[i] == root) {
				cnt = i;
				break;
			}
		}
		l = cnt - st;
		r = end - cnt;

		if (l > 0) {
			Node.left = new TreeNode(B[x - r - 1]);
			construct(Node.left, A, B, st, cnt - 1, x - r - 1);
		}

		if (r > 0) {
			Node.right = new TreeNode(B[x - 1]);
			construct(Node.right, A, B, cnt + 1, end, x - 1);
		}

	}

	public TreeNode buildTree(int[] A, int[] B) {
		TreeNode ans = new TreeNode(B[B.length - 1]);
		construct(ans, A, B, 0, A.length - 1, B.length - 1);
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int A[] = new int[n];
		int B[] = new int[n];

		for (int i = 0; i < n; i++)
			A[i] = s.nextInt();
		for (int i = 0; i < n; i++)
			B[i] = s.nextInt();

		System.out.println(new ConstructWithInorderPostorder().buildTree(A, B));
		s.close();
	}

}
