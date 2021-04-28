package ib.scaler.day52_Mar30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class FlattenLinkedList {

	class ListNode {
		int val;
		ListNode right, down;

		ListNode(int x) {
			val = x;
			right = down = null;
		}
	}

	ListNode flatten(ListNode root) {
		ListNode curr, nxt, pre, tmp;
		pre = null;
		curr = root;
		nxt = curr.right;

		while (curr.right != null || curr.down != null) {
			if (curr.down != null) {
				tmp = curr.down;
				curr.down = tmp.down;
				tmp.down = null;

				pre = curr;
				nxt = curr.right;
				while (nxt != null && nxt.val < tmp.val) {
					pre = nxt;
					nxt = nxt.right;
				}
				pre.right = tmp;
				tmp.right = nxt;
			} else
				curr = nxt;

			nxt = curr.right;
		}

		pre = root;
		nxt = root.right;

		while (nxt != null) {
			tmp = nxt;
			nxt = nxt.right;
			tmp.right = null;
			pre.down = tmp;
			pre = tmp;
		}

		return root;
	}

	BufferedReader br;
	PrintWriter out;

	void solve() {
		int t = ni();
		while (t-- > 0) {
			int n = ni();
			ListNode head = null;
			ListNode pre = null;
			for (int i = 0; i < n; i++) {
				int m = ni();
				ListNode p1 = null;
				while (m-- > 0) {
					int x = ni();
					ListNode temp = new ListNode(x);
					if (head == null)
						head = temp;
					if (p1 == null) {
						if (pre != null)
							pre.right = temp;
						pre = temp;
					} else {
						p1.down = temp;
					}
					p1 = temp;
				}
			}
			ListNode flat = flatten(head);
			ListNode temp = flat;
			boolean first = true;
			while (temp != null) {
				if (!first)
					out.print("-> ");
				out.print(temp.val + " ");
				temp = temp.down;
				first = false;
			}
			out.println();
		}
	}

	int ni() {
		return Integer.parseInt(ns());
	}

	StringTokenizer ip;

	String ns() {
		if (ip == null || !ip.hasMoreTokens()) {
			try {
				ip = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new InputMismatchException();
			}
		}
		return ip.nextToken();
	}

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	public static void main(String[] args) {
		new FlattenLinkedList().run();
	}
}