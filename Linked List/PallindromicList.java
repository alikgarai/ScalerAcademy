package ib.scaler.day52_Mar30;

import java.util.Scanner;

public class PallindromicList {

	public int solve(ListNode A) {
		int maxlen = 1, len;
		ListNode curr, prev, nxt, l, r, c1, c2;
		prev = null;
		curr = A;

		while (curr != null) {
			nxt = curr.next;
			curr.next = prev;
			len = 1;
			l = prev;
			r = nxt;
			while (l != null && r != null && l.val == r.val) {
				len += 2;
				l = l.next;
				r = r.next;
			}
			maxlen = Math.max(maxlen, len);
			prev = curr;
			curr = nxt;
		}

		c1 = prev;
		c2 = prev.next;
		prev = null;

		while (c1 != null && c2 != null) {
			nxt = c2.next;
			c2.next = c1;
			c1.next = prev;

			if (c1.val == c2.val) {
				len = 2;
				l = prev;
				r = nxt;
				while (l != null && r != null && l.val == r.val) {
					len += 2;
					l = l.next;
					r = r.next;
				}
				maxlen = Math.max(maxlen, len);
			}
			prev = c1;
			c1 = c2;
			c2 = nxt;
		}

		return maxlen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		System.out.print(new PallindromicList().solve(A));

		s.close();
	}

}
