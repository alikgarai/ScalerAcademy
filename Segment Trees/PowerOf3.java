package ib.scaler.day66_Apr13;

import java.util.ArrayList;
import java.util.Scanner;

public class PowerOf3 {

	int tree[];
	int res;

	void buildTree(int idx, int start, int end, String A) {
		if (start == end)
			tree[idx] = A.charAt(start) - '0';
		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			buildTree(lc, start, mid, A);
			buildTree(rc, mid + 1, end, A);

			int tmp;
			if ((end - mid) % 2 == 0)
				tmp = (tree[lc] == 1) ? 1 : (tree[lc] == 2) ? 2 : 0;
			else
				tmp = (tree[lc] == 1) ? 2 : (tree[lc] == 2) ? 1 : 0;

			tree[idx] = (tmp + tree[rc]) % 3;
		}
	}

	void query(int idx, int start, int end, int L, int R) {
		// No Overlap
		if (L > end || start > R)
			return;

		// Complete Overlap
		if (L <= start && end <= R) {
			int tmp;
			if ((end - start + 1) % 2 == 0)
				tmp = (res == 1) ? 1 : (res == 2) ? 2 : 0;
			else
				tmp = (res == 1) ? 2 : (res == 2) ? 1 : 0;

			res = (tmp + tree[idx]) % 3;
			return;
		}

		// Partial Overlap
		int mid = (start + end) / 2;
		int lc = 2 * idx + 1;
		int rc = 2 * idx + 2;
		query(lc, start, mid, L, R);
		query(rc, mid + 1, end, L, R);
	}

	void update(int idx, int start, int end, int id) {
		if (start > id || id > end)
			return;

		if (start == end) {
			if (tree[idx] == 0)
				tree[idx] = 1;
		}

		else {
			int mid = (start + end) / 2;
			int lc = 2 * idx + 1;
			int rc = 2 * idx + 2;
			update(lc, start, mid, id);
			update(rc, mid + 1, end, id);

			int tmp;
			if ((end - mid) % 2 == 0)
				tmp = (tree[lc] == 1) ? 1 : (tree[lc] == 2) ? 2 : 0;
			else
				tmp = (tree[lc] == 1) ? 2 : (tree[lc] == 2) ? 1 : 0;

			tree[idx] = (tmp + tree[rc]) % 3;
		}
	}

	public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {
		ArrayList<Integer> ans = new ArrayList<>();

		int n = A.length();

		int x = (int) Math.ceil(Math.log(n) / Math.log(2));
		x = (int) Math.pow(2, x + 1) - 1;
		tree = new int[x];

		buildTree(0, 0, n - 1, A);

		int l = B.size();
		for (int i = 0; i < l; i++) {
			int val = B.get(i).get(0);
			switch (val) {
			case 0:
				res = 0;
				query(0, 0, n - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1);
				ans.add(res);
				break;

			case 1:
				update(0, 0, n - 1, B.get(i).get(1) - 1);
				ans.add(-1);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		String A = s.next();
		int n = s.nextInt();
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			B.add(new ArrayList<>());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
			B.get(i).add(s.nextInt());
		}

		System.out.println(new PowerOf3().solve(A, B));
		s.close();
	}

}
