package ib.scaler.day66_Apr13;

import java.util.ArrayList;
import java.util.Scanner;

public class RangeMinimumQueries {

	int tree[];

	void buildTree(int idx, int start, int end, ArrayList<Integer> A) {
		if (start == end)
			tree[idx] = A.get(start);
		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			buildTree(lc, start, mid, A);
			buildTree(rc, mid + 1, end, A);
			tree[idx] = Math.min(tree[lc], tree[rc]);
		}
	}

	int query(int idx, int start, int end, int L, int R) {
		if (L > end || start > R) // No Overlap
			return Integer.MAX_VALUE;
		if (L <= start && end <= R)
			return tree[idx]; // Complete Overlap

		// Partial Overlap
		int mid = (start + end) / 2;
		int lc = 2 * idx + 1;
		int rc = 2 * idx + 2;

		return Math.min(query(lc, start, mid, L, R), query(rc, mid + 1, end, L, R));
	}

	void update(int idx, int start, int end, int id, int val) {
		if (start > id || id > end)
			return;

		if (start == end)
			tree[idx] = val;

		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			update(lc, start, mid, id, val);
			update(rc, mid + 1, end, id, val);
			tree[idx] = Math.min(tree[lc], tree[rc]);
		}
	}

	public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();

		int n = A.size();
		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		x = (int) Math.pow(2, x + 1) - 1;
		tree = new int[x];

		buildTree(0, 0, n - 1, A);
		int l = B.size();
		for (int i = 0; i < l; i++) {
			int val = B.get(i).get(0);
			switch (val) {
			case 0:
				update(0, 0, n - 1, B.get(i).get(1) - 1, B.get(i).get(2));
				break;

			case 1:
				ans.add(query(0, 0, n - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1));
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++)
			A.add(s.nextInt());

		n = s.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			B.add(new ArrayList<>());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
		}

		System.out.println(new RangeMinimumQueries().solve(A, B));
		s.close();
	}
}
