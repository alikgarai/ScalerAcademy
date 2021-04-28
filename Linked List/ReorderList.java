package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class ReorderList {

	public ListNode reverseBetween(ListNode A, int B, int C) {
		ListNode tmp = A, st, pre, nxt, curr;

		while (B > 2) {
			tmp = tmp.next;
			B--;
			C--;
		}
		st = tmp;
		while (C-- > 1)
			tmp = tmp.next;

		if (B == 1)
			curr = st;
		else {
			curr = st.next;
			st.next = tmp;
		}
		pre = tmp.next;

		while (curr != tmp) {
			nxt = curr.next;
			curr.next = pre;
			pre = curr;
			curr = nxt;
		}
		curr.next = pre;

		return (B == 1) ? tmp : A;
	}

	public ListNode reorderList(ListNode A) {
		int n = 0;
		ListNode c1 = null, c2 = A, n1, n2;

		while (c2 != null) {
			c1 = c2;
			c2 = c2.next;
			n++;
		}

		if (n == 1)
			return A;

		A = reverseBetween(A, n / 2 + 1, n);
		c2 = c1;
		c1 = A;

		n = n / 2;
		while (n-- > 1) {
			n1 = c1.next;
			c1.next = c2;
			n2 = c2.next;
			c2.next = n1;
			c1 = n1;
			c2 = n2;
		}
		c1.next = c2;

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ReorderList rl = new ReorderList();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		A = rl.reorderList(A);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}

}
