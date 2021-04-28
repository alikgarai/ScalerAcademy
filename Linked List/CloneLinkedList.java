package ib.scaler.day50_Mar27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class CloneLinkedList {

	class ListNode {
		int val;
		ListNode next, random;

		ListNode(int x) {
			val = x;
			next = random = null;
		}
	}

	ListNode cloneList(ListNode A) {
		ListNode tmp1, tmp2, nxt, node;

		tmp1 = A;
		while (tmp1 != null) {
			nxt = tmp1.next;
			node = new ListNode(tmp1.val);
			tmp1.next = node;
			node.next = nxt;
			tmp1 = nxt;
		}

		tmp1 = A;
		while (tmp1 != null) {
			nxt = tmp1.random;
			tmp1.next.random = nxt.next;
			tmp1 = tmp1.next.next;
		}

		node = A.next;
		tmp1 = A;
		tmp2 = node;
		while (tmp2.next != null) {
			tmp1.next = tmp2.next;
			tmp1 = tmp2.next;
			tmp2.next = tmp1.next;
			tmp2 = tmp1.next;
		}
		tmp1.next = null;

		return node;
	}

	BufferedReader br;
	PrintWriter out;

	void solve() {
		int t = ni();
		while (t-- > 0) {
			int n = ni();
			ListNode head = null;
			ListNode pre = null;
			HashMap<Integer, ListNode> mp = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int x = ni();
				ListNode temp = new ListNode(x);
				mp.put(x, temp);
				if (head == null)
					head = temp;
				else
					pre.next = temp;
				pre = temp;
			}

			ListNode h = head;
			for (int i = 0; i < n; i++) {
				int x = ni();
				ListNode temp = mp.get(x);
				h.random = temp;
				h = h.next;
			}

			ListNode h2 = cloneList(head);
			if (head.equals(h2))
				return;
			h = h2;
			boolean first = true;
			while (h != null) {
				if (!first) {
					out.print("-> ");
				}
				first = false;
				out.print(h.val + " ");
				h = h.next;
			}
			h = h2;
			out.println();
			while (h != null) {
				out.print(h.val + " -> " + h.random.val + " ");
				h = h.next;
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
		new CloneLinkedList().run();
	}

}
