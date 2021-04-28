package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class KReverseLinkedList {

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

	public ListNode reverseList(ListNode A, int B) {
		if (B == 1)
			return A;
		int n = 0, l = 0;
		ListNode c1 = A;
		while (c1 != null) {
			n++;
			c1 = c1.next;
		}
		n = n / B;
		while (n-- > 0) {
			A = reverseBetween(A, l + 1, l + B);
			l += B;
		}

		return A;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		KReverseLinkedList kr = new KReverseLinkedList();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		int B = s.nextInt();
		A = kr.reverseList(A, B);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}
}
