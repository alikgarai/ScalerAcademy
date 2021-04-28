package ib.scaler.day50_Mar27;

import java.util.Scanner;

public class ReverseLinkedList {

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		ReverseLinkedList rll = new ReverseLinkedList();
		ListNode A = new ListNode(s.nextInt());
		ListNode tail = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			tail.next = tmp;
			tail = tmp;
		}
		int B = s.nextInt();
		int C = s.nextInt();
		A = rll.reverseBetween(A, B, C);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}
}
