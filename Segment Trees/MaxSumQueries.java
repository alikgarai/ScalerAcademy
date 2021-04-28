package ib.scaler.day123_Jun19;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxSumQueries {

	class Node {
		int sum, maxSum, prefixSum, suffixSum;
	}

	Node tree[];

	void buildTree(int idx, int start, int end, ArrayList<Integer> A) {
		if (start == end) {
			tree[idx].sum = A.get(start);
			tree[idx].maxSum = A.get(start);
			tree[idx].prefixSum = A.get(start);
			tree[idx].suffixSum = A.get(start);
		} else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			buildTree(lc, start, mid, A);
			buildTree(rc, mid + 1, end, A);
			tree[idx].sum = tree[lc].sum == Integer.MIN_VALUE ? tree[rc].sum
					: tree[rc].sum == Integer.MIN_VALUE ? tree[lc].sum : tree[lc].sum + tree[rc].sum;
			int pSum = tree[lc].sum == Integer.MIN_VALUE ? tree[rc].prefixSum
					: tree[rc].prefixSum == Integer.MIN_VALUE ? tree[lc].sum : tree[lc].sum + tree[rc].prefixSum;
			tree[idx].prefixSum = Math.max(tree[lc].prefixSum, pSum);
			int sSum = tree[lc].suffixSum == Integer.MIN_VALUE ? tree[rc].sum
					: tree[rc].sum == Integer.MIN_VALUE ? tree[lc].suffixSum : tree[lc].suffixSum + tree[rc].sum;
			tree[idx].suffixSum = Math.max(tree[rc].suffixSum, sSum);
			int psSum = tree[rc].prefixSum == Integer.MIN_VALUE ? tree[lc].suffixSum
					: tree[lc].suffixSum == Integer.MIN_VALUE ? tree[rc].prefixSum
							: tree[rc].prefixSum + tree[lc].suffixSum;
			tree[idx].maxSum = Math.max(tree[idx].prefixSum,
					Math.max(tree[idx].suffixSum, Math.max(psSum, Math.max(tree[lc].maxSum, tree[rc].maxSum))));
		}
	}

	Node queryTree(int idx, int start, int end, int L, int R) {

		Node result = new Node();
		result.sum = result.maxSum = result.prefixSum = result.suffixSum = Integer.MIN_VALUE;

		// No Overlap
		if (L > end || start > R)
			return result;

		// Complete Overlap
		if (L <= start && end <= R)
			return tree[idx];

		// Partial Overlap
		int mid = (start + end) / 2;
		int lc = 2 * idx + 1;
		int rc = 2 * idx + 2;

		Node left = queryTree(lc, start, mid, L, R);
		Node right = queryTree(rc, mid + 1, end, L, R);
		result.sum = left.sum == Integer.MIN_VALUE ? right.sum
				: right.sum == Integer.MIN_VALUE ? left.sum : left.sum + right.sum;
		int pSum = left.sum == Integer.MIN_VALUE ? right.prefixSum
				: right.prefixSum == Integer.MIN_VALUE ? left.sum : left.sum + right.prefixSum;
		result.prefixSum = Math.max(left.prefixSum, pSum);
		int sSum = left.suffixSum == Integer.MIN_VALUE ? right.sum
				: right.sum == Integer.MIN_VALUE ? left.suffixSum : left.suffixSum + right.sum;
		result.suffixSum = Math.max(right.suffixSum, sSum);
		int psSum = right.prefixSum == Integer.MIN_VALUE ? left.suffixSum
				: left.suffixSum == Integer.MIN_VALUE ? right.prefixSum : right.prefixSum + left.suffixSum;
		result.maxSum = Math.max(result.prefixSum,
				Math.max(result.suffixSum, Math.max(psSum, Math.max(left.maxSum, right.maxSum))));

		return result;
	}

	void updateTree(int idx, int start, int end, int id, int val) {
		if (start > id || id > end)
			return;

		if (start == end) {
			tree[idx].sum = val;
			tree[idx].maxSum = val;
			tree[idx].prefixSum = val;
			tree[idx].suffixSum = val;
		}

		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			updateTree(lc, start, mid, id, val);
			updateTree(rc, mid + 1, end, id, val);
			tree[idx].sum = tree[lc].sum == Integer.MIN_VALUE ? tree[rc].sum
					: tree[rc].sum == Integer.MIN_VALUE ? tree[lc].sum : tree[lc].sum + tree[rc].sum;
			int pSum = tree[lc].sum == Integer.MIN_VALUE ? tree[rc].prefixSum
					: tree[rc].prefixSum == Integer.MIN_VALUE ? tree[lc].sum : tree[lc].sum + tree[rc].prefixSum;
			tree[idx].prefixSum = Math.max(tree[lc].prefixSum, pSum);
			int sSum = tree[lc].suffixSum == Integer.MIN_VALUE ? tree[rc].sum
					: tree[rc].sum == Integer.MIN_VALUE ? tree[lc].suffixSum : tree[lc].suffixSum + tree[rc].sum;
			tree[idx].suffixSum = Math.max(tree[rc].suffixSum, sSum);
			int psSum = tree[rc].prefixSum == Integer.MIN_VALUE ? tree[lc].suffixSum
					: tree[lc].suffixSum == Integer.MIN_VALUE ? tree[rc].prefixSum
							: tree[rc].prefixSum + tree[lc].suffixSum;
			tree[idx].maxSum = Math.max(tree[idx].prefixSum,
					Math.max(tree[idx].suffixSum, Math.max(psSum, Math.max(tree[lc].maxSum, tree[rc].maxSum))));
		}
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();

		int n = A.size();
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		x = (int) Math.pow(2, x + 1) - 1;
		tree = new Node[x];

		for (int i = 0; i < x; i++)
			tree[i] = new Node();

		buildTree(0, 0, n - 1, A);

		int l = B.size();
		for (int i = 0; i < l; i++) {
			int val = B.get(i).get(0);
			switch (val) {
			case 1:
				updateTree(0, 0, n - 1, B.get(i).get(1) - 1, B.get(i).get(2));
				break;

			case 2:
				ans.add(queryTree(0, 0, n - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1).maxSum);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();

		int n = s.nextInt();
		for (int i = 0; i < n; i++)
			A.add(s.nextInt());

		n = s.nextInt();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(s.nextInt());
			tmp.add(s.nextInt());
			tmp.add(s.nextInt());
			B.add(tmp);
		}
		System.out.println(new MaxSumQueries().solve(A, B));
		s.close();
	}
}
