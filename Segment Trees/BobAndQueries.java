package ib.scaler.day66_Apr13;

import java.util.ArrayList;
import java.util.Scanner;

public class BobAndQueries {

	int tree[];

	int query(int idx, int start, int end, int L, int R) {
		// No Overlap
		if (L > end || start > R)
			return 0;
		// Complete Overlap
		if (L <= start && end <= R)
			return tree[idx];
		// Partial Overlap
		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;

			return query(lc, start, mid, L, R) + query(rc, mid + 1, end, L, R);
		}
	}

	void update(int idx, int start, int end, int id, int type) {
		if (start > id || id > end)
			return;

		if (start == end) {
			if (type == 1)
				tree[idx]++;
			else if (tree[idx] != 0)
				tree[idx]--;
		}

		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			update(lc, start, mid, id, type);
			update(rc, mid + 1, end, id, type);
			tree[idx] = tree[lc] + tree[rc];
		}
	}

	public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();

		int x = (int) Math.ceil(Math.log(A) / Math.log(2));
		x = (int) Math.pow(2, x + 1) - 1;
		tree = new int[x];

		int l = B.size();
		for (int i = 0; i < l; i++) {
			int val = B.get(i).get(0);
			switch (val) {
			case 1:
				update(0, 0, A - 1, B.get(i).get(1) - 1, 1);
				break;

			case 2:
				update(0, 0, A - 1, B.get(i).get(1) - 1, 2);
				break;

			case 3:
				ans.add(query(0, 0, A - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1));
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int A = s.nextInt();
		int n = s.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			B.add(new ArrayList<>());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
		}

		System.out.println(new BobAndQueries().solve(A, B));
		s.close();
	}

}
