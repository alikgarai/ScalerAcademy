package ib.scaler.day66_Apr13;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryUpdates {

	int tree[];

	void buildTree(int idx, int start, int end) {
		if (start == end)
			tree[idx] = 1;
		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			buildTree(lc, start, mid);
			buildTree(rc, mid + 1, end);
			tree[idx] = tree[lc] + tree[rc];
		}
	}

	int query(int idx, int start, int end, int id) {

		if (start == end)
			return start + 1;

		int mid = (start + end) / 2;
		int lc = 2 * idx + 1;
		int rc = 2 * idx + 2;

		if (tree[lc] >= id)
			return query(lc, start, mid, id);
		else {
			return query(rc, mid + 1, end, id - tree[lc]);
		}
	}

	void update(int idx, int start, int end, int id) {
		if (start > id || id > end)
			return;

		if (start == end)
			tree[idx] = 0;
		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			update(lc, start, mid, id);
			update(rc, mid + 1, end, id);
			tree[idx] = tree[lc] + tree[rc];
		}
	}

	public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();

		int x = (int) Math.ceil(Math.log(A) / Math.log(2));
		x = (int) Math.pow(2, x + 1) - 1;
		tree = new int[x];

		buildTree(0, 0, A - 1);

		int l = B.size();
		for (int i = 0; i < l; i++) {
			int val = B.get(i).get(0);
			switch (val) {
			case 0:
				update(0, 0, A - 1, B.get(i).get(1) - 1);
				break;

			case 1:
				if (B.get(i).get(1) > tree[0])
					ans.add(-1);
				else
					ans.add(query(0, 0, A - 1, B.get(i).get(1)));
				break;
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
		}

		System.out.println(new BinaryUpdates().solve(A, B));
		s.close();
	}

}
