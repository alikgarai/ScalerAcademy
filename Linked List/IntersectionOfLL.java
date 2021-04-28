package ib.scaler.day52_Mar30;

import java.util.Scanner;

public class IntersectionOfLL {

	public ListNode getIntersectionNode(ListNode a, ListNode b) {
		int c1 = 0, c2 = 0, diff;

		ListNode tmp = a;
		while (tmp != null) {
			tmp = tmp.next;
			c1++;
		}
		tmp = b;
		while (tmp != null) {
			tmp = tmp.next;
			c2++;
		}
		if (c1 == 0 || c2 == 0)
			return null;

		diff = Math.abs(c1 - c2);
		if (c1 > c2) {
			tmp = a;
			while (diff-- > 0)
				tmp = tmp.next;

			while (tmp != null && !tmp.equals(b)) {
				tmp = tmp.next;
				b = b.next;
			}
			return tmp;
		} else {
			tmp = b;
			while (diff-- > 0)
				tmp = tmp.next;

			while (tmp != null && !tmp.equals(a)) {
				tmp = tmp.next;
				a = a.next;
			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		IntersectionOfLL ill = new IntersectionOfLL();
		ListNode A = new ListNode(s.nextInt());
		ListNode t1 = A;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			t1.next = tmp;
			t1 = tmp;
		}
		n = s.nextInt();
		ListNode B = new ListNode(s.nextInt());
		ListNode t2 = B;
		while (n-- > 1) {
			ListNode tmp = new ListNode(s.nextInt());
			t2.next = tmp;
			t2 = tmp;
		}
		n = s.nextInt();
		if (n > 0) {
			ListNode C = new ListNode(s.nextInt());
			ListNode t3 = C;
			while (n-- > 1) {
				ListNode tmp = new ListNode(s.nextInt());
				t3.next = tmp;
				t3 = tmp;
			}
			t1.next = C;
			t2.next = C;
		}
		A = ill.getIntersectionNode(A, B);
		while (A != null) {
			System.out.print(A.val + " ");
			A = A.next;
		}
		s.close();
	}

}
